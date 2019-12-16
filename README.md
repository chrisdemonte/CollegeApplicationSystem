# CollegeApplicationSystem
An Android App for searching for colleges
Christopher DeMonte

1) Data Retrieval:

	The app has the required data of all 7112 colleges stored on the CollegeScoreCard database. The app
does not call the CollegeScoreCard API itself, as there were complications querying the API from an android
divice. Instead the data was collected in a seperate java program, which queried the API and stored the data
into a txt file that could be easily parsed by the android App. The txt file is saved onto a firebase database 
that is linked to the project, so the App can update its internal storage of the database on request. There
is an SQL database as well, for fast searching, which updates its data when the txt file is updated.
In the future as, the CollegeScoreCard database is updated, an admin can recollect data, uploaded it 
to the firebase cloud, and every App will download the updated data and over write the old SQL tables on
 started up. 

2) User Profile:

	Users can make a profile holding their name, email address, SAT scores, username, and password.
A user can also save favorite schools onto a list which can be easily accessed and editted. The UserManager 
class contains a TreeMap which can hold any number of users. 

3) User Login:
	
	On start up the user is directed to a login screen where they can login with a previously made
username and password, or create a new account. Upon successful login the user is redirected to a menu
with the search options.

4) College Search:

	The user can search for a school using multiple perameters, including school name, id, state, city,
region, and tuition. If none of the data fields are filled, the search will return all schools. If some of
the fields are used, they will be used as filters for the return results, and any fields left blank will be 
ignored. After pressing the search button, the user is presented a list of schools. Tapping the schools on 
the list will open a window with more information on the school and a button for adding the school to favorites.

5) College Match Up:

	This functions much the same as the search module, but search results are automatically filtered, so
that only schools with SAT data are returned. Additionally, the list will be color coded to show at a glance
which schools the user is more likely to get into according to their SAT score: Green is very good, Yellowish
Green is average, and Orange-Red is not so good. 
