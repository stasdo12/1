// script.js

// Function to handle smooth scrolling on navigation link click
$(document).ready(function () {

    $('a.nav-link').on('click', function (event) {
        if (this.hash !== "") {
            event.preventDefault();

            const hash = this.hash;


            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 800, function () {

                window.location.hash = hash;
            });
        }
    });
});
// Function to change text in a loop
const texts = [
    "Хочеш стати тату майстром?",
    "Do you want to become a tattoo master?",
    "Давно ввагався?",
    "Have you been thinking about it for a while?",
    "Почни сьогодні!",
    "Start today!",
    "Висока зарплатня",
    "High salary",
    "Не впусти свій шанс",
    "Don't miss your chance",
    "А ми тобі допоможемо!",
    "And we will help you!"
];

let currentIndex = 0;

function changeText() {
    $("#changing-text").fadeOut(400, function () {
        $(this).text(texts[currentIndex]).fadeIn(400);
    });

    currentIndex = (currentIndex + 1) % texts.length;
}


setInterval(changeText, 3000);





$(document).ready(function () {
    let $scrollToTop = $('#scrollToTop');

    $scrollToTop.hide();

    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $scrollToTop.fadeIn();
        } else {
            $scrollToTop.fadeOut();
        }
    });

    $scrollToTop.click(function () {
        $('html, body').animate({ scrollTop: 0 }, 800);
        return false;
    });
});

