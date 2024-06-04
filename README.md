<h1>Food Delivery App</h1>

<h2>Running Mysql Database as docker container</h2>
<code>$ docker run -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag</code>

<h2>Running RabbitMQ as docker container</h2>
<code>$ docker run -p 5672:5672 -d --hostname my-rabbit --name some-rabbit rabbitmq:3</code>

<h1></h1>

<h2>Rest Interface to register customers</h2>
<span>/api/customers/register</span>
<code>
{
    "username": "ashish",
    "password": "admin",
    "role": "CUSTOMER",
    "latitude": 232,
    "longitude": 43243,
    "address": "MY ADDRESS"
}
</code>

<h2>Rest Interface to register restaurant</h2>
<span>/api/restaurants/register</span>
<code>
{
    "username": "abc",
    "password": "abc",
    "role": "RESTAURANT",
    "latitude": 232,
    "longitude": 43243,
    "restaurantName": "Abc top Restaurant",
    "location": "Sector 82, Gurgaon, Haryana"
}
</code>

<h2>Rest Interface to add dishes to restaurant</h2>
<span>/api/restaurant/update</span>
<code>
{
    "id": 1,
    "dishes": [
        {
            "id": 5,
            "dishName": "Burger",
            "shortDescription": "cheese burger",
            "dishType": "VEG",
            "spicy": "MEDIUM_SPICY",
            "price": 20
        }
    ]
}
</code>

<h2>Rest Interface to place an order</h2>
<span>/api/orders/place</span>
<code>
{
    "orderId": "1",
    "userId": "2",
    "restaurantId": "1",
    "orderedItems": ["1"]
}
</code>

<h2>Once the order is placed, order details will be placed in RabbitMQ queue and the status will change accordingly</h2>
<span>Order Status</span>
<code>
public enum OrderStatus {
    PLACED,
    CONFIRMED,
    PREPARING,
    READY_TO_DELIVER,
    DISPATCHED,
    ACCEPTED,
    DELIVERED,
    CANCELLED
}
</code>
