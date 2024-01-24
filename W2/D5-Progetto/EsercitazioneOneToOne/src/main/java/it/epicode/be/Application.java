package it.epicode.be;

import it.epicode.be.dao.BlogpostsDao;
import it.epicode.be.dao.CategoriesDao;
import it.epicode.be.dao.DocumentsDao;
import it.epicode.be.dao.UsersDao;
import it.epicode.be.entities.BlogPost;
import it.epicode.be.entities.Category;
import it.epicode.be.entities.Document;
import it.epicode.be.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_unit4_w3_d3_relazioni");

    public static void main(String[] args) {
        System.out.println("Esercitazione W3 - D3");
        EntityManager em = emf.createEntityManager();

        UsersDao usersDao = new UsersDao(em);
        DocumentsDao documentsDao = new DocumentsDao(em);
        BlogpostsDao blogpostsDao = new BlogpostsDao(em);
        CategoriesDao categoriesDao = new CategoriesDao(em);

        // ******************************** 1 TO 1 **********************************
        User aldo = new User("Aldo", "Belgio");
        //usersDao.save(aldo);
        User aldoFromDB = usersDao.findById(1);
        Document aldoDoc = new Document(LocalDate.now(), "Italy", "213oijoi231j", aldoFromDB);
        documentsDao.save(aldoDoc);
        // ******************************** 1 TO MANY **********************************
        BlogPost java = new BlogPost("React", "React è bellissimo ma non come Java", aldoFromDB);
        blogpostsDao.save(java);
        BlogPost javaFromDB = blogpostsDao.findById(6);
        System.out.println(javaFromDB);

        System.out.println("------------ BIDIREZIONALITA' PER IL 1 TO MANY ----------------------");
        aldoFromDB.getBlogPostList().forEach(System.out::println);

        // ******************************** MANY TO MANY **********************************
		Category javaCategory = new Category("Java");
		Category oopCategory = new Category("OOP");
		Category beCategory = new Category("Backend");
        categoriesDao.save(javaCategory);
        categoriesDao.save(oopCategory);
        categoriesDao.save(beCategory);

//        Category javaCategory = categoriesDao.findById(8);
//        Category oopCategory = categoriesDao.findById(9);
//        Category beCategory = categoriesDao.findById(10);

        javaFromDB.setCategoryList(new ArrayList<>(Arrays.asList(javaCategory, oopCategory, beCategory)));
        blogpostsDao.save(javaFromDB);

        // Leggere tutte le categorie di un certo blog
        System.out.println("Lista delle categorie del blog java");
        javaFromDB.getCategoryList().forEach(System.out::println);

        // Leggere tutti i blog di una certa categoria
        System.out.println("Lista di tutti i blog associati ad una certa categoria");
        javaCategory.getBlogPostList().forEach(System.out::println);


    }
}
