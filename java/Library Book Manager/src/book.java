public class book{
      private String title, author;
      private long ISBN;
      private int pages, year;
      public book(String t, String a, long i, int p, int y){
            title=t;
            author=a;
            ISBN=i;
            pages=p;
            year=y;
      }
      public String getTitle(){
            return title;
      }
      public String getAuthor(){
            return author;
      }
      public long getISBN(){
            return ISBN;
      }
      public int getPages(){
            return pages;
      }
      public int getYear(){
            return year;
      }
      public int getAge(){
            return (2025-year);
      }
      public String toString(){
            return (""+ title + ", " + author + ", " + ISBN + ", " + pages + ", " + year);
      }



}