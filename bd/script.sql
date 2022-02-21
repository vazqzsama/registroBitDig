
create or replace PACKAGE PKG_REC_AFL_SIT IS

    FUNCTION F_SET_PAGER(pQUERY IN VARCHAR2,pLIMIT IN NUMBER,pOFFSET IN NUMBER) RETURN VARCHAR2;

    PROCEDURE P_GET_AFIL_RECUPERAR( P_CURSOR OUT GLOBALPKG.RCT1,
                                    pCORREOS   IN VARCHAR2,
                                    pIDSOCIOS IN VARCHAR2,
                                    pFECHA_INI IN VARCHAR2,
                                    pFECHA_FIN IN VARCHAR2);

    FUNCTION F_GET_CLIENTES_QUERY(P_EMAIL IN VARCHAR2, P_NOM IN VARCHAR2, P_APAT IN VARCHAR2, P_AMAT IN VARCHAR2,
            P_IDSOCIO IN VARCHAR2, P_ESTATUS IN VARCHAR2, P_SORT_BY IN VARCHAR2, P_ORDER_BY IN VARCHAR2 )  RETURN VARCHAR2;

    FUNCTION F_GET_CLIENTES_COUNT(P_EMAIL IN VARCHAR2, P_NOM IN VARCHAR2,
            P_APAT IN VARCHAR2, P_AMAT IN VARCHAR2, P_IDSOCIO IN VARCHAR2, P_ESTATUS IN VARCHAR2 ) RETURN NUMBER;

    PROCEDURE P_GET_CLIENTES_VIEW( P_CURSOR OUT GLOBALPKG.RCT1, P_EMAIL IN VARCHAR2, P_NOM IN VARCHAR2,
            P_APAT IN VARCHAR2, P_AMAT IN VARCHAR2, P_IDSOCIO IN VARCHAR2, P_ESTATUS IN VARCHAR2,
            P_SORT_BY IN VARCHAR2, P_ORDER_BY IN VARCHAR2, P_LIMIT_N IN NUMBER, P_OFFSET_N IN NUMBER);

END PKG_REC_AFL_SIT;



create or replace PACKAGE BODY PKG_REC_AFL_SIT IS
---------------------------------------------------------------------------------------------
-- FUNCIONES Y PROCEDIMIENTOS PARA APLICACION DE RECUPERACION DE AFILIACIONES LANDING
---------------------------------------------------------------------------------------------
    FUNCTION F_SET_PAGER(pQUERY IN VARCHAR2,pLIMIT IN NUMBER,pOFFSET IN NUMBER)
        RETURN VARCHAR2 IS SQL_QUERY VARCHAR2(10000);
      BEGIN
            SQL_QUERY:='SELECT * FROM (
                        SELECT ROWNUM AS RN , RESULTSET.*  FROM (
                           '||pQUERY||'
                        ) RESULTSET WHERE ROWNUM <= ( '|| (pLIMIT + pOFFSET) ||' )
                        )WHERE RN >= ( '|| (pOFFSET+1)  ||') ';
             RETURN SQL_QUERY;
      END;
-----------------------------------------------------------------
    PROCEDURE P_GET_AFIL_RECUPERAR( P_CURSOR OUT GLOBALPKG.RCT1,
                                                pCORREOS   IN VARCHAR2,
                                                pIDSOCIOS IN VARCHAR2,
                                                pFECHA_INI IN VARCHAR2,
                                                pFECHA_FIN IN VARCHAR2) IS
        V_SQL       VARCHAR2(10000) := ' ';
        F_RFN_CRR    VARCHAR2(10000) := ' ';
        F_FCH  VARCHAR2(10000) := ' ';
    BEGIN
        IF pCORREOS IS NOT NULL AND pIDSOCIOS IS NOT NULL THEN
            F_RFN_CRR := ' AND ( EMAIL IN ('||pCORREOS||') OR IDSOCIO IN ('||pIDSOCIOS||') ) ';
        ELSIF pCORREOS IS NOT NULL THEN
            F_RFN_CRR := ' AND EMAIL IN ('||pCORREOS||') ';
        ELSIF pIDSOCIOS IS NOT NULL THEN
            F_RFN_CRR := ' AND IDSOCIO IN ('||pIDSOCIOS||') ';
        END IF;

        IF pFECHA_INI IS NOT NULL AND pFECHA_FIN IS NOT NULL THEN
            F_FCH := ' AND (TRUNC(FALTA) >= TO_DATE ('''||pFECHA_INI||''',''DD/MM/RRRR HH24:MI:SS'')
                            AND TRUNC(FALTA) <= TO_DATE('''||pFECHA_FIN||''',''DD/MM/RRRR'')) ';
        ELSIF pFECHA_INI IS NOT NULL THEN
            F_FCH := ' AND TRUNC(FALTA) >= TO_DATE('''||pFECHA_INI||''',''DD/MM/RRRR'') ';
        ELSIF pFECHA_FIN IS NOT NULL THEN
            F_FCH := ' AND TRUNC(FALTA) <= TO_DATE('''||pFECHA_FIN||''',''DD/MM/RRRR'') ';
        END IF;

        V_SQL := 'WITH AF AS (SELECT ROW_NUMBER() OVER (PARTITION BY TRIM(SO_NOM_STR),TRIM(SO_APAT_STR),TRIM(SO_AMAT_STR),SO.SO_FNAC_DT,SO_TEL4_STR,SO.SO_EMAIL_STR ORDER BY SO.SO_FALTA_DT) ID,
            SO.SO_ID_STR IDSOCIO,TRIM(SO_NOM_STR) SONOMBRE,TRIM(SO_APAT_STR) APELLIDOPATERNO,TRIM(SO_AMAT_STR) APELLIDOMATERNO,SO.SO_EMAIL_STR EMAIL,
            SO_TEL4_STR TELEFONO,SO.TI_CVE_N CVETIENDA,SO_CALLE_STR CALLE,SO_NUM_STR NOEXTERIOR,SO_NUMINT_STR NOINTERIOR,so.so_tipo_str,
            SO_COL_STR COLONIA,MU_CVE_N MUNICIPIO,SO_MUNIC_STR MUNICIPIODESC,SO.ED_CVE_N ESTADO,EDO.EDO_DESC_STR ESTADODESC,SO_CD_STR CIUDAD,
            SO_CP_STR CP,SO_REF_STR REFERENCIA,'''' ENTRECALLES,SO_FALTA_DT FALTA,''-'' ARTICULOS
            FROM PS_SOCIOS@LRCORPPRICE SO
            LEFT JOIN PS_EDO@LRCORPPRICE EDO ON (EDO.ED_CVE_N = SO.ED_CVE_N AND EDO.PA_CVE_N = SO.PA_CVE_N)
            LEFT JOIN AFILIA_BITACORA_DIGITAL BD ON (BD.SO_ID_STR = SO.SO_ID_STR OR BD.SO_EMAIL_STR = SO.SO_EMAIL_STR)
            WHERE SO.SO_SEXO_STR IS NULL AND SO.TI_CVE_N = 29 AND BD.ABD_CVE_N IS NULL )
            SELECT A.*,PD.PT_NUM_N PEDIDO,PD.PT_IMPORTE_N IMPORTETOTAL,PD.PT_IMPORTE_N-PD.PT_COSENV_N IMPORTEPEDIDO,PD.PT_COSENV_N IMPORTEENVIO,
            PD.PT_DESC_N DESCUENTO,0 SEGUROENVIO,2 FORMADEPAGO, '''' ARTICULOS,2 TIPOVENTA,1 METODOPAGO,PD.PT_EST_STR FROM AF A
            LEFT JOIN UDONLINE.PS_PEDTMK@lrcorpprice PD ON (PD.SO_ID_STR = A.IDSOCIO AND A.CVETIENDA = PD.TI_CVE_N AND PD.PT_TIP_STR = ''F'')
            WHERE A.ID = 1 AND PD.PT_NUM_N IS NOT NULL AND PD.PT_EST_STR != ''C'''||F_RFN_CRR||F_FCH;

        OPEN P_CURSOR FOR V_SQL;
    END;
-----------------------------------------------------------------
    FUNCTION  F_GET_CLIENTES_QUERY(P_EMAIL IN VARCHAR2, P_NOM IN VARCHAR2, P_APAT IN VARCHAR2,
            P_AMAT IN VARCHAR2, P_IDSOCIO IN VARCHAR2, P_ESTATUS IN VARCHAR2, P_SORT_BY IN VARCHAR2, P_ORDER_BY IN VARCHAR2)
            RETURN VARCHAR2 IS
        FILTROS  VARCHAR2(10000) := ' ';
    BEGIN
        IF P_EMAIL IS NOT NULL THEN
            FILTROS := FILTROS||' AND EMAIL LIKE ''%'||P_EMAIL||'%'' ';
        END IF;
        IF P_NOM IS NOT NULL THEN
            FILTROS := FILTROS||' AND SONOMBRE LIKE ''%'||P_NOM||'%'' ';
        END IF;
        IF P_APAT IS NOT NULL THEN
            FILTROS := FILTROS||' AND APELLIDOPATERNO LIKE ''%'||P_APAT||'%'' ';
        END IF;
        IF P_AMAT IS NOT NULL THEN
            FILTROS := FILTROS||' AND APELLIDOMATERNO LIKE ''%'||P_AMAT||'%'' ';
        END IF;
        IF P_IDSOCIO IS NOT NULL THEN
            FILTROS := FILTROS||' AND IDSOCIO = '''||P_IDSOCIO||''' ';
        END IF;
        IF P_ESTATUS IS NOT NULL THEN
            FILTROS := FILTROS||' AND ESTATUSSOCIO = '''||P_ESTATUS||''' ';
        END IF;
        IF P_SORT_BY IS NOT NULL THEN
           FILTROS := FILTROS||' ORDER BY ' ||P_SORT_BY||' '||P_ORDER_BY||' ';
        END IF;

        RETURN 'WITH AF AS (SELECT so.so_tipo_str ESTATUSSOCIO,SO_TEL4_STR TELEFONO,SO.TI_CVE_N CVETIENDA,SO_CALLE_STR CALLE,SO_NUM_STR NOEXTERIOR,SO_NUMINT_STR NOINTERIOR,
            ROW_NUMBER() OVER (PARTITION BY TRIM(SO_NOM_STR),TRIM(SO_APAT_STR),TRIM(SO_AMAT_STR),SO.SO_FNAC_DT,SO_TEL4_STR,SO.SO_EMAIL_STR ORDER BY SO.SO_FALTA_DT) ID,
            SO.SO_ID_STR IDSOCIO,TRIM(SO_NOM_STR) SONOMBRE,TRIM(SO_APAT_STR) APELLIDOPATERNO,TRIM(SO_AMAT_STR) APELLIDOMATERNO,SO.SO_EMAIL_STR EMAIL,
            SO_COL_STR COLONIA,MU_CVE_N MUNICIPIO,SO_MUNIC_STR MUNICIPIODESC,SO.ED_CVE_N ESTADO,EDO.EDO_DESC_STR ESTADODESC,SO_CD_STR CIUDAD,
            SO_CP_STR CP,SO_REF_STR REFERENCIA,'''' ENTRECALLES,SO_FALTA_DT FALTA FROM PS_SOCIOS@lrcorpprice SO
            LEFT JOIN PS_EDO@LRCORPPRICE EDO ON (EDO.ED_CVE_N = SO.ED_CVE_N AND EDO.PA_CVE_N = SO.PA_CVE_N)
            LEFT JOIN AFILIA_BITACORA_DIGITAL BD ON (BD.SO_ID_STR = SO.SO_ID_STR OR BD.SO_EMAIL_STR = SO.SO_EMAIL_STR)
            WHERE SO.SO_SEXO_STR IS NULL AND SO.TI_CVE_N = 29 AND BD.ABD_CVE_N IS NULL AND SO.USR_CVE_PSTR = ''UECOMM''
            AND TRUNC(SO.SO_FALTA_DT) >= TO_DATE (''01/09/2021 00:00:00'',''DD/MM/RRRR HH24:MI:SS'') ),
            INFPED AS (SELECT A.*,PD.PT_NUM_N PEDIDO,PD.PT_IMPORTE_N IMPORTETOTAL,PD.PT_IMPORTE_N-PD.PT_COSENV_N IMPORTEPEDIDO,PD.PT_COSENV_N IMPORTEENVIO,
            PD.PT_DESC_N DESCUENTO,PD.PT_EST_STR ESTATUSPEDIDO FROM AF A
            LEFT JOIN UDONLINE.PS_PEDTMK@lrcorpprice PD ON (PD.SO_ID_STR = A.IDSOCIO AND A.CVETIENDA = PD.TI_CVE_N) WHERE A.ID = 1)
            SELECT * FROM  INFPED I where (ESTATUSPEDIDO = ''C'' OR PEDIDO IS NULL) '||FILTROS;
    END;
-----------------------------------------------------------------
    FUNCTION F_GET_CLIENTES_COUNT(P_EMAIL IN VARCHAR2, P_NOM IN VARCHAR2, P_APAT IN VARCHAR2,
                P_AMAT IN VARCHAR2, P_IDSOCIO IN VARCHAR2, P_ESTATUS IN VARCHAR2) RETURN NUMBER IS
        SQL_QUERY VARCHAR2(10000);
        RESULTSET_SIZE NUMBER(12);
    BEGIN
        SQL_QUERY:=' SELECT COUNT(*) FROM ( '|| PKG_REC_AFL_SIT.F_GET_CLIENTES_QUERY(P_EMAIL, P_NOM,
            P_APAT, P_AMAT, P_IDSOCIO,P_ESTATUS,NULL, NULL ) ||' ) ';
        EXECUTE IMMEDIATE SQL_QUERY INTO RESULTSET_SIZE;
        RETURN RESULTSET_SIZE;
    END;
-----------------------------------------------------------------
    PROCEDURE P_GET_CLIENTES_VIEW( P_CURSOR OUT GLOBALPKG.RCT1, P_EMAIL IN VARCHAR2, P_NOM IN VARCHAR2,
            P_APAT IN VARCHAR2, P_AMAT IN VARCHAR2, P_IDSOCIO IN VARCHAR2, P_ESTATUS IN VARCHAR2, P_SORT_BY IN VARCHAR2,
            P_ORDER_BY IN VARCHAR2, P_LIMIT_N IN NUMBER, P_OFFSET_N IN NUMBER) IS
        SQL_QUERY VARCHAR2(10000);
        QUERY_BASE VARCHAR2(10000);
    BEGIN
          QUERY_BASE := PKG_REC_AFL_SIT.F_GET_CLIENTES_QUERY(P_EMAIL, P_NOM,P_APAT,
              P_AMAT, P_IDSOCIO, P_ESTATUS,P_SORT_BY, P_ORDER_BY );

          SQL_QUERY:=F_SET_PAGER(QUERY_BASE,P_LIMIT_N,P_OFFSET_N);
          OPEN P_CURSOR FOR SQL_QUERY;
    END;
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
END;

-----------------------------------------------------------------
-----------------------------------------------------------------
-- TRIGER PARA ACTUALIZACION DE FOTOS
-----------------------------------------------------------------
-----------------------------------------------------------------
drop trigger PSIWEB.TRG_PS_IMAGENES_AFIL;

create or replace TRIGGER PSIWEB.TRG_PS_IMAGENES_AFIL
  AFTER INSERT ON PSIWEB.WSE_FOTOS_CAT
  FOR EACH ROW
DECLARE
    TABLENAME VARCHAR2(1000) := '';
    COLUMNAME VARCHAR2(1000) := '';
    MSJ VARCHAR2(1000) := '';
    LINKDB VARCHAR2(1000) := '';
    SQLQUERY VARCHAR2(1000) := '';
    EXISTE NUMBER(2) := 0;
    TIPO_N NUMBER(2) := 0;
    SO_ID_STR VARCHAR2(1000) := '';
    TI_CVE_N NUMBER(2) := 0;
BEGIN

    SELECT B.TIPO_N,B.SO_ID_STR,B.TI_CVE_N,D.LINKREMOTE INTO TIPO_N,SO_ID_STR,TI_CVE_N,LINKDB
    FROM WSE_UPDATE_FOTOS B
    LEFT JOIN dba_databases@lrcorpprice D ON (D.TABLE_ID = B.TI_CVE_N AND STATUS = 'A')
    WHERE ID_N = :NEW.WUF_ID_N;

    if (TIPO_N = 1) then
        TABLENAME := 'PSFOTO.PS_SOFOTO_IFE';
        COLUMNAME := 'SO_FOTO_IFE_B';
    elsif (TIPO_N = 2) then
        TABLENAME := 'PSFOTO.PS_SOFOTO';
        COLUMNAME := 'SO_FOTO_B';
    elsif (TIPO_N = 3) then
        TABLENAME := 'PSFOTO.PS_SOFOTO_DOM';
        COLUMNAME := 'SO_FOTO_IFE_B';
    end if;

    EXECUTE IMMEDIATE 'SELECT COUNT(SO_ID_STR) FROM '||TABLENAME||'@'||LINKDB||' WHERE SO_ID_STR = '''||SO_ID_STR||'''' INTO EXISTE;

    IF EXISTE = 0 THEN
        SQLQUERY := 'INSERT INTO '||TABLENAME||'@'||LINKDB||' (SO_ID_STR,TI_CVE_N,'||COLUMNAME||') select SO_ID_STR,TI_CVE_N,FOTO_BL ' ||
                    'from WSE_UPDATE_FOTOS WHERE ID_N = '||:NEW.WUF_ID_N;
    ELSIF EXISTE = 1 THEN
        SQLQUERY := 'UPDATE '||TABLENAME||'@'||LINKDB||' SET '||COLUMNAME||' = (select FOTO_BL from WSE_UPDATE_FOTOS WHERE ID_N = '
                    ||:NEW.WUF_ID_N||') WHERE SO_ID_STR = '''||SO_ID_STR||''' AND TI_CVE_N = '||TI_CVE_N;
    END IF;

    INSERT INTO PSIWEB.WSE_ERRORES_2 (DETALLE) VALUES (SQLQUERY);
    EXECUTE IMMEDIATE SQLQUERY;

    EXCEPTION
        WHEN OTHERS THEN
            MSJ := sqlerrm;
            INSERT INTO PSIWEB.WSE_ERRORES_2 (DETALLE) VALUES (MSJ);

END TRG_PS_IMAGENES_AFIL;

-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------
-----------------------------------------------------------------


