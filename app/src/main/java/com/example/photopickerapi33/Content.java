package com.example.photopickerapi33;

class Content {
   static String content = "<!DOCTYPE html>\n" +
           "            <HTML>\n" +
           "               <HEAD>\n" +
           "                  <TITLE>Understanding HTML File Format</TITLE>\n" +
           "               </HEAD>\n" +
           "               <BODY>\n" +
           "                  <script>\n" +
           "                     window.onload=function(){\n" +
           "                     \n" +
           "                     const input = document.querySelector(\"input\")\n" +
           "                     const output = document.querySelector(\"output\")\n" +
           "                     let imagesArray = []\n" +
           "                     input.addEventListener(\"change\", () => {\n" +
           "                       const file = input.files\n" +
           "                       imagesArray.push(file[0])\n" +
           "                       displayImages()\n" +
           "                     })\n" +
           "                     function displayImages() {\n" +
           "                       let images = \"\"\n" +
           "                       imagesArray.forEach((image, index) => {\n" +
           "                       images += `<div class=\"image\">\n" +
           "                             <img src=\"${URL.createObjectURL(image)}\" alt=\"image\">\n" +
           "                             <span onclick=\"deleteImage(${index})\">&times;</span>\n" +
           "                           </div>`\n" +
           "                       })\n" +
           "                     output.innerHTML = images\n" +
           "                     console.log(images)\n" +
           "                     }\n" +
           "                     function deleteImage(index) {\n" +
           "                     imagesArray.splice(index, 1)\n" +
           "                     displayImages()\n" +
           "                     }}\n" +
           "                  </script>\n" +
           "                  <input type=\"file\" accept=\"image/jpeg, image/png, image/jpg\">\n" +
           "                  <output></output>\n" +
           "               </BODY>\n" +
           "            </HTML>";
}
