document.addEventListener("DOMContentLoaded", function () {
    const keyboard = document.querySelector(".keyboard");

    function handleKeyPress(target) {
        if (target.classList.contains("key")) {
            if (target.classList.contains("space")) {
                Keyboard.commitText(" ", 1);
            } else if (target.classList.contains("backspace")) {
                Keyboard.deleteLastCharacter();
            } else {
                Keyboard.commitText(target.innerText, 1);
            }
        }
    }

    keyboard.addEventListener("touchstart", function (event) {
        event.preventDefault();
        for (let touch of event.touches) {
            const target = document.elementFromPoint(touch.clientX, touch.clientY);
            if (target) handleKeyPress(target);
        }
    }, { passive: false });

    keyboard.addEventListener("click", function (event) {
        handleKeyPress(event.target);
    });
});
