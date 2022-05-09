<h1># cinemaRoomRestService</h1>

The first and second stages of the project are completed. Some examples from the application can be seen below.

<h3>/seats endpoint provides available seats:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/seats.png" style="max-width: 100%;">


<h3>Let's buy the seat at first row, first column, which is available, by sending a post request to /purchase endpoint. If transaction is succesful,  it returns the seat and the price with 200 OK Http response:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/buy%20first%20seat.png" style="max-width: 100%;">


<h3>Let's try to buy same seat again, and it returns a 400 bad request with an error "The ticket has been already purchased!"</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/already%20purchased%20exception.png" style="max-width: 100%;">



<h3>This time, let try to buy 15th column, which is out of bounds. It returns a 400 bad request with an error "The number of a row of a column is out of bounds!"</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/out%20of%20bounds%20exception.png" style="max-width: 100%;">

<h3>In our cinema, first 4 rows are expensive(10) and the rest is cheaper(8). Let's buy a cheaper ticket:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/cheaper%20ticket.png" style="max-width: 100%;">

<h3>Lastly,  when we reach the /seats endpoint again, we can see that first seat is not listed anymore, because it's been purchased at the second example.</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/available%20seats%20after%20purchase.png" style="max-width: 100%;">

<h1>Project Overview</h1>

First two stages (of four) are completed of the project. Green bars indicate completed topics. Progress as of May 10th:

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/project%20overview.png" style="max-width: 100%;">

