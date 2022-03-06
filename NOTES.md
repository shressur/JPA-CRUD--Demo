####4. API (redirects to appropriate CRUD services) -> 
######[ equivalent to Controller in JDBC approach ]<br>
@RestController: class level annotation<br>
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping<br>
Talks to Services so @Autowire the service
####3. Services (does the actual work, CRUD) -> 
######[ equivalent to JDBC implementation of DAO in JDBC approach ]<br>
@Service: class level annotation<br>
Talks to repository @Autowire repository (uses JPA exposed methods for CRUD operation)
####2. Repositories (interface, extends JpaRepository<model_class, primaryKey_type>) -> 
######[ equivalent to DAO in JDBC approach ]<br>
Interface<br>
Extends JpaRepository<cls, pk><br>
cls: Entity class name that this repository represents<br>
pk: type of primary key field in this Entity<br>
(usually no methods are needed to be defined as they are automatically exposed by extending jpa repository so after
autowiring services can access built-in jpa methods for CRUD)
####1. Entities (pojo representation of table)
######[ equivalent to Model in JDBC approach ]<br>
@Entity: class level annotation<br>
@Table(name="table_name")   //if omitted it assumes the table name is to be the same as the class name<br>
<pre>
Note: Spring boot assumes that DB ALREADY EXISTS and is configured in application.properties file else causes an 
error: <strong>Error creating bean with name 'entityManagerFactory'</strong>
</pre>
@Id<br>
@GeneratedValue<br>
@Column
####\# base package -> where main method lies
####\# application.properties
######Data source properties:
<pre>
spring.datasource.url=jdbc:postgresql://localhost:5432/db_name
spring.datasource.driver-class-name= org.postgresql.Driver
spring.datasource.username= db_user_name
spring.datasource.password= db_pass
</pre>
######Jpa/Hibernate properties:
<pre>
spring.jpa.hibernate.ddl-auto = update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true<br>
https://docs.spring.io/spring-cloud-dataflow/docs/1.1.2.RELEASE/reference/html/configuration-rdbms.html
</pre>
<!-- other helpful extra properties -->
<!--
server.port=8080<br>
spring.datasource.url=jdbc:postgresql://localhost:5555/jpademo?createDatabaseIfNotExist=true
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform = org.hibernate.dialect.PostgreSQL94Dialect
-->
#### # postgreSQL dependency:
<pre>
&lt;dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
&lt;/dependency>
</pre>
#### # If Spring Security dependency is used then every request (API) is needs authentication by default
So for simple JDBC example, no need to add Spring Security
#### # Encrypt password with BCrypt: requires spring boot
spring boot by default secures all API endpoints<br>
Application class:<br>
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
#### # Using PostMan or calling APIs
<pre>
- camelCase table field names are converted into snake_case automatically in db
- however while saving/calling api you must use filed names exactly as written in the model/entity class
</pre>
#### # Troubleshooting
<pre>
<strong>1. Consider defining a bean of type</strong> or <strong> 
   Could not autowire. No beans of 'xxxxxx' type found</strong>
=> Make sure you have proper annotations on classes example: <strong>Service class</strong> needs <strong>@Service</strong> annotation
<strong>2. Error creating bean with name 'entityManagerFactory'</strong>
=> Make sure DB already exists in the system
</pre>
#### # @Column
<pre>
@Column(columnDefinition = "varchar(255) default 'John Snow'", nullable=false)
@Column(columnDefinition = "integer default 25 NOT NULL", updatable=false, precision=12, scale=2, unique=true)
@Column(columnDefinition = "boolean default false")
</pre>
#### # Make sure everything goes inside the main package (where main application resides)
If main package is "com.example.test" then all entities, repos, services, controllers should be inside "com.example.test"<br> 
example: Services => com.example.test.servicesbr>
Otherwise you might have to use @ComponentScan(packages_to_scan) in main file/class