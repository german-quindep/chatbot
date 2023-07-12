package com.example.chatbot.Shared.Querys;

public enum QuerysSql {
        QueryCedula;

        public static final String QUERY_OTP = """
                            SELECT * FROM tbl_otp
                            WHERE codigo = :#{#otp.codigo} AND id_chat = :#{#otp.idChat} AND status = 0
                            ORDER BY created ASC LIMIT 1
                        """;
        public static final String QUERY_GET_CEDULA = """
                        SELECT * FROM tbl_otp
                        WHERE id_chat = :idChat AND DATE(created)=CURDATE() AND status = 1
                        ORDER BY created ASC LIMIT 1
                        """;
        public static final String QUERY_EMPLOYE_SEARCH = """
                        SELECT * FROM empleados WHERE identified=:identified
                        """;
        public static final String QUERY_PDF_USER = """
                        SELECT * FROM tbl_pdf_user
                        WHERE id_chat= :#{#consult.idChat} AND DATE(CREATED)= :#{#consult.date1}
                        ORDER BY created DESC LIMIT 1
                        """;
        public static final String QUERY_AUTH_BOT = """
                        SELECT * FROM auth_bot
                        WHERE chat_id = :#{#consult.idChat} AND DATE(finish_token) = :#{#consult.date1}
                        ORDER BY init_token DESC LIMIT 1
                        """;
        public static final String QUERY_OTP_CEDULA = """
                        SELECT * FROM tbl_otp
                        WHERE identificacion = :#{#otp.identificacion} AND id_chat = :#{#otp.idChat}
                        AND DATE(created)= CURDATE()
                        ORDER BY created DESC LIMIT 1
                        """;
        public static final String QUERY_BLOQ_USER = """
                        SELECT * FROM tbl_bloq_user
                        WHERE id_chat = :idChat AND intentos = 3 LIMIT 1
                        """;
        public static final String QUERY_INTENTOS_USER = """
                        SELECT * FROM tbl_bloq_user
                        WHERE id_chat = :idChat AND DATE(created)=CURDATE() LIMIT 1
                        """;
}
