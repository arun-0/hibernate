package com.arun.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gallery")
public class Gallery
{
   @Id
   @Column(name = "id", nullable = false)
   private int id;
   
   @Column(name = "name", nullable = true, length = 128)
   private String name;
   
   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinTable(name = "imagetogallery", joinColumns = { 
         @JoinColumn(name = "galleryid",
         nullable = false, updatable = false)
      }, inverseJoinColumns = { 
         @JoinColumn(name = "imageid",
         nullable = false, updatable = false)
      }
   )
   private Set<Image> associatedImages;
   
   public Gallery()
   {
      setAssociatedImages(new HashSet<Image>());
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Set<Image> getAssociatedImages()
   {
      return associatedImages;
   }

   public void setAssociatedImages(Set<Image> associatedImages)
   {
      this.associatedImages = associatedImages;
   }
}
