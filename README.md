<h1># cinemaRoomRestService</h1>

As of June 1st, the project is completed. Some examples from the application can be seen below.


<h3>/seats endpoint provides available seats:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/seats.png" style="max-width: 100%;">


<h3>Let's buy the seat at first row, first column, which is available, by sending a post request to /purchase endpoint. If transaction is succesful,  it returns the seat and the price with 200 OK Http response:</h3>

<p><i>Update: now it also returns with a token, which will be used for returning tickets later.</i></p>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/purchase.png" style="max-width: 100%;">


<h3>Let's try to buy same seat again, and it returns a 400 bad request with an error "The ticket has been already purchased!"</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/already%20purchased%20exception.png" style="max-width: 100%;">


<h3>This time, let try to buy 15th column, which is out of bounds. It returns a 400 bad request with an error "The number of a row of a column is out of bounds!"</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/out%20of%20bounds%20exception.png" style="max-width: 100%;">


<h3>In our cinema, first 4 rows are expensive(10) and the rest is cheaper(8). Let's buy a cheaper ticket:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/cheaper%20ticket.png" style="max-width: 100%;">


<h3>Lastly,  when we reach the /seats endpoint again, we can see that first seat is not listed anymore, because it's been purchased at the second example.</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/available%20seats%20after%20purchase.png" style="max-width: 100%;">


<h2>Updates after completing the third stage of the project:</h2>

<h3>Now we have /return endpoint and we are able to return the ticket by using token provided during purchase:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/returnedTicket.png" style="max-width: 100%;">


<h3>Seat is returned, added to available seats list, and the list is sorted:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/availableSeatsAfterReturn.png" style="max-width: 100%;">


<h3>If we try to use same token again, it returns a "wrong token" exception, because the token is not a valid one anymore.</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/invalidToken.png" style="max-width: 100%;">


<h3>/stats endpoint provides current statistics and http response 200, if the correct password provided:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/get%20stats.png">

<h3>If the correct password is not provided, it returns an error message and http response 401 unauthorised:</h3>

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/unauthorised.png">


<h1>Project Overview</h1>

All the project-related topics and implementations are completed. Green bars indicate completed topics.

<img src="https://raw.githubusercontent.com/khvci/cinemaRoomRestService/master/screenshots/project%20overview.png" style="max-width: 100%;">

