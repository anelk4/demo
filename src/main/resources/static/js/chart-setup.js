// src/main/resources/static/js/chart-setup.js
// пока работает с нереальными данными, потом поменяем
//// ожидает базу данных
var ctx = document.getElementById('ratingsGraph').getContext('2d');
var ratingsGraph = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June'],
        datasets: [{
            label: 'Rating',
            data: [0, 10, 5, 2, 20, 30, 45],
            backgroundColor: 'rgba(0, 123, 255, 0.2)',
            borderColor: 'rgba(0, 123, 255, 1)',
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});


function createSnowflake() {
    const snowflake = document.createElement('div');
    snowflake.classList.add('snowflake');
    snowflake.textContent = '❄'; // Символ снежинки
    snowflake.style.cssText = `
        position: absolute;
        top: ${Math.random() * window.innerHeight}px; // Случайная стартовая позиция сверху в пределах высоты окна
        left: ${Math.random() * window.innerWidth}px; // Случайная стартовая позиция слева в пределах ширины окна
        opacity: ${Math.random()}; // Случайная прозрачность снежинки
        font-size: ${Math.random() * 24 + 10}px; // Размер снежинки от 10 до 34px
        color: white;
        user-select: none;
        pointer-events: none;
    `;

    document.body.appendChild(snowflake);

    setTimeout(() => {
        snowflake.style.top = `${window.innerHeight}px`; // Снежинка падает вниз до конца страницы
        snowflake.style.opacity = 0; // Снежинка становится прозрачной
    }, 0);

    setTimeout(() => {
        snowflake.remove(); // Удаление снежинки после падения
    }, 7000); // Снежинка исчезает через 7 секунд после создания
}

setInterval(createSnowflake, 200); // Создание новой снежинки каждые 200 миллисекунд

/*
document.addEventListener('DOMContentLoaded', function() {
    var snowFlakeContainer = document.getElementById('snow');
    var createSnowFlake = function() {
        var snowFlake = document.createElement('div');
        snowFlake.className = 'snowflake';
        snowFlake.style.left = Math.random() * window.innerWidth + 'px';
        snowFlake.style.animationDuration = Math.random() * 3 + 2 + 's'; // Duration between 2 and 5 seconds
        snowFlake.style.opacity = Math.random();
        snowFlake.style.fontSize = Math.random() * 10 + 10 + 'px'; // Size between 10px and 20px

        snowFlakeContainer.appendChild(snowFlake);

        setTimeout(function() {
            snowFlake.remove();
        }, 5000); // Remove snowflake after 5 seconds
    };

    setInterval(createSnowFlake, 100); // Create a new snowflake every 100ms
});
*/
