<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/main.css">
    <script src="https://kit.fontawesome.com/90c8120d4c.js" crossorigin="anonymous"></script>
    <title>Hotel Booking</title>
</head>

<body>
    <div id="container">
        <%@ include file="includes/header.jsp" %>
            <div id="intro">
                <div class="cover">
                    <img src="img/homepage-background.jpg" alt="">
                    <div class="message">
                        <h1 style="text-shadow: 1px 1px white;">Welcome Home</h1>
                        <p style="text-shadow: 2px 2px #eb4f4f54;">Rent unique places to stay from local hosts in 20+
                            country</p>
                    </div>
                </div>
            </div>
            <div id="content">
                <p class="title">Inspiration for your next trip</p>
                <div id="places">
                    <div class="place-item">
                        <a href="destination?id=1">
                            <div class="place-img">
                                <img width="320" height="170" src="img/banner1.jpg" alt="">
                            </div>
                            <div class="place-name">New York</div>
                        </a>
                    </div>
                    <div class="place-item">
                        <a href="destination?id=2">
                            <div class="place-img">
                                <img width="320" height="170" src="img/banner2.jpg" alt="">
                            </div>
                            <div class="place-name">Nha Trang City</div>
                        </a>
                    </div>
                    <div class="place-item">
                        <a href="destination?id=3">
                            <div class="place-img">
                                <img width="320" height="170" src="img/banner3.jpg" alt="">
                            </div>
                            <div class="place-name">Vung Tau City</div>
                        </a>
                    </div>
                    <div class="place-item">
                        <a href="destination?id=4">
                            <div class="place-img">
                                <img width="320" height="170" src="img/banner4.jpg" alt="">
                            </div>
                            <div class="place-name">Da Nang City</div>
                        </a>
                    </div>
                </div>
            </div>
            <div id="slider">
                <img src="img/slider.jpg" alt="">
                <div class="message" style="text-shadow: 2px 2px #f28282d9;">Your trip Your place</div>
            </div>
            <%@ include file="includes/footer.jsp" %>
    </div>

    <script src="javascript/main.js"></script>
</body>

</html>