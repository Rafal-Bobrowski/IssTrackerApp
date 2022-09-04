# IssTrackerApp
This project I have made during my Java bootcamp. 
The project was created for trainging purpose. 

You can run project: https://tracker-iss.herokuapp.com/reports-position
Starting server can take a while, so please be patient during first load.

Some of used technologies:
Java, Spring, Springboot, Hibernate, HTML, Bootstrap, HTTP, MVC.

What it does?
It downloads data from http://open-notify.org/ api. Then saves information about current Iss position and people in space into H2 databes.
All saved datas are accesible via HTTP requests.
There are 2 views. First contains information about current position of Iss presented in paginated table and visualization of position on the Earth, the second one contains table with people present in space.

Visualisation of current position and its trace.
![Screen1](https://user-images.githubusercontent.com/103534928/188262450-616c6d6f-6519-468d-af3a-8e349162b8e8.PNG)

Paginated table containing position reports.
![Screen2](https://user-images.githubusercontent.com/103534928/188262477-9ab75596-1fd8-4b7e-961c-d1cc066b661b.PNG)

Table with people in space.
![Screen3](https://user-images.githubusercontent.com/103534928/188262489-72158a70-b13c-4dd8-8569-b80d935c176f.PNG)
