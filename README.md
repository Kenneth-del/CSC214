# CSC214
Repository for school project
Please note: all fxml files should be in the 'srs' directory as the current implementation assumes this. 
If the jfornix dependency will be used you will need to include it in your project build path. 
To do this you right click on the .jar file and click update build path. Add the jar from there and you're set. 
As it stands the fxml implementation works, if there are any other ideas on how to make this work better please let me 
know or make the changes yourself. 
Please note: Do not introduce a dependency unless the software is using it in more than two separate situations and it 
contributes some significant function or feel to the program.  
****Please also note: Do not under any circumstances add test code to this branch. This is for and only for code 
that functions and works. You should commit code to your own personal branches if certain code would be considered experimental.****

The UI team should also be sure to include id's in the fxml documents and be mindful of text properties and future 
implementation so the programming team doesn't have to make significant edits to the fxml documents. 
In addition, I encourage the UI team to look at the current UI implementation and make the appropriate modifications 
to the fxml documents based on how they were modified. 
The programming team shouldn't have to make edits to the fxml documents if they were created correctly. Also, the UI 
team should be mindful of the scope of the project, 
this is a kiosk application and although we may not force a full screen window the program should work in full screen mode. 
As it stands the window will not display properly in full screen mode, p
lease change the UI components accordingly. 

As for the programming team, the initial controller needs to be implemented. 
This includes pulling user information and passwords from their respective database and checking input validity as well as
getting the user input in the first place. 
Please be mindful of most reasonable input checking scenarios when validating user input. The security hashing function is 
written. All that needs to be done to implement it is to create an object and pass the user password to it. 
Set the used password to that hash. In addition, when creating test data use the password hash function in a simi
