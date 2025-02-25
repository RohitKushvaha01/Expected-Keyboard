    document.addEventListener("DOMContentLoaded", function () {
    const keyboard = document.querySelector(".keyboard");

    keyboard.addEventListener("click", function (event) {
        // Check if the clicked element has the 'key' class
        if (event.target.classList.contains("key")) {
            const key = event.target.innerText;

            //call the backend
            Keyboard.commitText(key,1)
        }
    });
});