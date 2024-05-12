package com.arun.hibernate;

import com.arun.hibernate.entities.Gallery;
import com.arun.hibernate.entities.Image;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
   public static void main(String[] argv) {

      Configuration con = new Configuration().configure("hibernate.cfg.xml");
      SessionFactory sf = con.buildSessionFactory();
      Session session = sf.openSession();

      Transaction tx;


//      // 0. Delete all existing records
//      tx = session.beginTransaction();
//      Query q = session.createQuery("delete from Image");
//      q.executeUpdate();
//      q = session.createQuery("delete from Gallery");
//      q.executeUpdate();
//      tx.commit();


      // 1
      Gallery gallery = new Gallery();
      gallery.setId(1);
      gallery.setName("My Test Gallery");

      Image img1 = new Image();
      img1.setId(2);
      img1.setFilePath("C:\\testimages\\img1.jpg");
      Image img2 = new Image();
      img2.setId(3);
      img2.setFilePath("C:\\testimages\\img2.jpg");

      gallery.getAssociatedImages().add(img1);
      gallery.getAssociatedImages().add(img2);

      tx = session.beginTransaction();
      session.save(gallery);
      tx.commit();

      //2
      tx = session.beginTransaction();
      // select image from Gallery gallery join gallery.associatedImages image where gallery.id = 1 order by image.id desc
      Query query = session.createQuery(
                      "select image from Gallery gallery join gallery.associatedImages image"
                              + " where gallery.id = :galId order by image.id desc"
              ).setParameter("galId", 1).
              setMaxResults(2);

      List<Image> imgs = query.list();
      tx.commit();

      for(Image image : imgs) {
         System.out.println(String.format("Image Id: %s", image.getId()));
         System.out.println(String.format("Image File Path: %s", image.getFilePath()));
      }

      // 3
      tx = session.beginTransaction();
      Gallery gal = (Gallery)session.get(Gallery.class, 1);
      Image img = (Image)session.get(Image.class, 3);
      gal.getAssociatedImages().remove(img);
      session.update(gal);
      tx.commit();

      // 4. Delete all existing records
      tx = session.beginTransaction();
      Query q = session.createQuery("delete from Image");
      q.executeUpdate();
      q = session.createQuery("delete from Gallery");
      q.executeUpdate();
      tx.commit();

      session.close();

   }
}