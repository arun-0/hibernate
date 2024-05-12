DROP TABLE IF EXISTS imagetogallery;
DROP TABLE IF EXISTS gallery;
DROP TABLE IF EXISTS image;

CREATE TABLE gallery (
   id int NOT NULL PRIMARY KEY,
   name VARCHAR(128) NULL
);

CREATE TABLE image (
       id int NOT NULL PRIMARY KEY,
       filepath VARCHAR(256) NULL
);

CREATE TABLE imagetogallery (
   id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   galleryid int NOT NULL,
   imageid int NOT NULL,

   FOREIGN KEY (galleryid) REFERENCES gallery(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
   FOREIGN KEY (imageid) REFERENCES image(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);



select image.id, image.filepath
from gallery join imagetogallery join image
    on imagetogallery.galleryid = gallery.id and imagetogallery.imageid = image.id
where gallery.id = 1 order by image.id desc;
