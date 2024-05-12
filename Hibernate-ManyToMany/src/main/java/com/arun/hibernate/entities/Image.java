package com.arun.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image
{
   @Id
   @Column(name = "id", nullable = false)
   private int id;
   
   @Column(name = "filepath", nullable = true, length = 256)
   private String filePath;
   
   @ManyToMany(fetch = FetchType.LAZY, mappedBy = "associatedImages")
   private Set<Gallery> associatedGalleries;

   public Image()
   {
      associatedGalleries = new HashSet<Gallery>();
   }
   
   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getFilePath()
   {
      return filePath;
   }

   public void setFilePath(String filePath)
   {
      this.filePath = filePath;
   }

   public Set<Gallery> getAssociatedGalleries()
   {
      return associatedGalleries;
   }

   public void setAssociatedGalleries(Set<Gallery> associatedGalleries)
   {
      this.associatedGalleries = associatedGalleries;
   }
}
