# FBI NIBRS Application Bundle 

## Setup
- You'll need to have the following minimum installation to work with the project   
  - JDK 21 (I use openjdk but Jetbrains will download a corretto JDK 21 for you if you wish)
  - If you use the command line a lot, you'll need Gradle 8.4 installed
  - Postgres database installed (I won't explain installation because you can follow instructions as well as anyone) 
  - Clone the repository from https://github.com/jmresler/fbi-nibrs-app.git and checkout fix-inf-recursion branch
  - Download the [NIBRS data for the state of Alabama, 2022 data](here|https://cde-prd-data.s3.us-gov-east-1.amazonaws.com/2022/AL-2022.zip?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIAQC732REK7QTUBF4U%2F20231204%2Fus-gov-east-1%2Fs3%2Faws4_request&X-Amz-Date=20231204T235237Z&X-Amz-Expires=900&X-Amz-Security-Token=FwoDYXdzEGYaDEH9ae2a46hkvVZK2CKhArWstD5RSU2FaHPVF2Yx2ikmtjQ%2Bv%2Bza7IBQxqjf84qnyzddgbGBAjbQgBEwTG%2F0kGdxnszYGcxW7j2JseiMbDCqLtNCQIr%2BKNnEQNvyffibd8cQnUaNRpDxSUXYONN%2FO7NKcDAFLTvNkuh3G2CidgeeW4QPm%2BLtJg%2FyAKIzrMFMobeJq17gL7SjEV1mZ9MMWQ75maaZQOzKF02HSZXFBaQOEBys3SSm0rFCol59ZlIXR7O3%2Frm0pl%2F9aG7deR3dPFzCM9Y9K9gzb1sol0G2IN1JdOfj%2Fklm3EfO8Z%2FcQX4hgjzdKAh8izFh2uJIAdEUGEMJNRK8uIQuao8lvcb2a%2BSdsPkT9OAoEinkLP29dAMkc7Pt5lftyuOe6rOgMD5gFBYom8O5qwYyLcfdGY1J36bIHrlTClgfUj9k4YdVyGioF04yyfWqcUe6bCBkMqzq9xpyEEV3Gw%3D%3D&X-Amz-Signature=6c25a9bbcb8067a16119b85f32d4245f6cc0fbd84fa4dfad55240d19258502ab&X-Amz-SignedHeaders=host)
  - I highly recommend an IDE of your choice

After you have all of this installed, you'll need to create a database named nibrs in postgres. 
This is an arbitrary name I picked and not specific to anything the DoJ uses. 
I currently have credentials for the postgres database in the application-postgres.yml file in the batch-entity-tester project.

You create the database as follows.
1. Launch pgadmin    
   <img src="images/pgadmin-initial-screen.png">
2. Select the servers tab on the left   
   <img src="images/pgadmin-servers.png">
3. Select the PostgreSQL 16 server node on the left   
   <img src="images/pgadmin-servers.png"> 
4. A login dialog will popup. Login with your admin credentials here:   
   <img src="images/postgres-login-dialog.png">   
5. Select the databases node on the left, right click on it and select create > database...   
   <img src="images/create-database-dialog.png">
6. A tabbed dialog will appear.  You really only need to fill out the "General" tab.   
   Enter the database name in the Database field (nibrs)   
   <img src="images/create-database-dialog-general-tab.png">   
   Enter the jmres user account you created in the Owner field (It's a dropdown)   
   Click save and you're done with pgadmin
7. You'll need to add this directory to your environment variables path in Windows.
   1. <img src="images/windows-path-variable-dialog.png">
   2. <img src="images/windows-path-variable-dialog-2.png">   
   3. <img src="images/windows-path-variable-dialog-3.png">
   4. <img src="images/windows-path-variable-dialog-4.png">
   5.Click on save and you're good.    

From now on, you'll be working from the command line because that's the way the DoJ set the database installation up.

1. Unzip the AL-2022.zip file you downloaded from the NIBRS site listed above into a directory named appropriate AL-2022.
   1. Open a Dos prompt and enter the AL-2022 directory      
        <img src="images/command-shell-one.png">   
   2. In that directory you'll want to execute these two commands:
      1. ``` psql nibrs < postgres_setuo.sql ``` You'll be prompted to login and when you run the command you should see    
         a stream of CREATE TABLE and then ALTER TABLE commands.        
      2. ``` psql nibrs < postgres_load.sql ``` Once again, login. There are a bunch of commands that stream by, some 
          of which indicate errors, I'm unsure if this is actually a problem or just part of the process.  
         ```CONTEXT:  COPY agencies, line 2 ERROR:  duplicate key value violates unique constraint "nibrs_activity_type_pk ``` 

Login to the database with your DB tool and confirm there is data there.

You should be good to go.

Going back to the errors in the load script, I suspect this is normal, I've checked the data and there are some gaps   
in the data in some of the tables. I checked the CSV files and there are some missing entries in them consistent with   
the entries in the table. In other words, the gaps in the CSV files are consistent with the gaps in the tables? {{shrug}}   

P.S. If you don't have a good DB visualization tool, I included an ER diagram in the form of a PDF named nibrs-er-diagram.pdf   
that might simplify things.
