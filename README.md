# HolidayReservationSystem
Holiday Reservation System to illustrate the idea of multitier architecture enterprise systems

The holiday reservation system is able to carry out the following use cases:
1) Login
- For a visitor to login to the system as a customer before a reservation can be made.
- It is assumed that the following three customers have already been pre-created (customer1@gmail.com/password, customer2@gmail.com/password, customer3@gmail.com/password)

2) Search Holiday
- The system should prompt the visitor to input the following information:
- Departure date
- Return date
- Departure city
- Destination city
- Number of travellers

The following information will also be generated:
- Ticket(s) for a flight departing anytime on the date of departure from an airport in the departure city and returning anytime on the return date. The landing schedule and departure schedule at the destination city airport can be any appropriate data.
- A rental car for collecting at the destination city airport one hour after the landing time at the destination city airport on the departure date and for returning one hour before the departure time on the return date.
- A hotel room in the destination city for check-in on the departure date and for check-out on the return date.

Note:
- The details are to be represented as simple string text to be stored in ItineraryItem.activity, e.g.,:
- Board flight XXX from ABC airport at 8:00 AM, 3 September 2018.
- Collect rental car model YYY at 9:00 AM, 3 September 2018.
- Check-in to hotel ZZZ at 10:00 AM, 3 September 2018.
- Check-in from hotel ZZZ at 12:00 PM, 5 September 2018.
- Return rental car model YYY at 1:00 PM, 5 September 2018.
- Board flight WWW from EFG airport at 2:00 PM, 5 September 2018.

3) Make Reservation
- Payment is to be made via credit card depending on the customer’s choice:
- If the customer selects VISA or MasterCard, the CreditCardProcessingSessionBean component will call the PayPalPayment class to complete the payment.
- If the customer selects AMEX, the CreditCardProcessingSessionBean component will call the ThirdPartyGatewayPayment class to complete the payment.
