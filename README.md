# Javax persistance API and MySQL  database pattern
https://www.youtube.com/watch?v=jB2uSJX7jnM&feature=emb_title&ab_channel=IntelliJIDEAbyJetBrains
## persistence.xml
```xml
        <properties>
            <property name="javax.persistence.cj.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/DATABASE_NAME?serverTimezone=UTC"/>
            <property name="javax.persistence.jdbc.user" value="NAME"/>
            <property name="javax.persistence.jdbc.password" value="PASSWORD"/>
            <property name="javax.persistence.schema-generation.database.action" value="create"/>
        </properties>
 ```
## pom.xml
 ```xml
       <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
        </dependency>
   ```
   
  ## e.g Friend.java
 ```java
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Friend {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;

    public Friend() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

```

 ## e.g main.java
 ```java
  public static void main(String[] args) {
        Friend friend = new Friend();
        friend.setName("Lubos");
        friend.setSurname("Sremanak");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(friend);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
```
