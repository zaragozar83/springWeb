# springWeb
# Este proyecto esta integrado con jndi, por lo cual si se requiere tener acceso a la base de datos, se debe de agregar al archivo 
# context.xml de nuestro servidor de servlets (tomcat en mi caso) la configuración de conexión a base de datos, de acuerdo a la configuración
# implementada en este proyecto, la configuración que debe agregarse al archivo es la siguiente:

<Resource 
	name="jdbc/nok" 
	auth="Container" 
	type="javax.sql.DataSource"
        maxActive="100" 
	maxIdle="30" 
	maxWait="10000"
        username="root"
	password="" 
	driverClassName="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/maqzar"/>
# La configuración debe de ser acore a los datos de acceso a la base de datos MySQL a la que se este conectando

