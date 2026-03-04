let timer = null;
let score = 0;


function startGame() {
  if (timer) return;
  window.addEventListener('keydown', handleKey);
  timer = setInterval(() => {
    const display = document.getElementById('display');
    display.innerText = Math.floor((Math.random() * 10));
  }, 1000);
}

function stopGame() {
  if(timer == null)
    return;
  window.removeEventListener('keydown', handleKey);
  clearInterval(timer);
  timer = null;
  alert("Final Number: " + score);
  score = 0;
}

function handleKey(event) {
  const key = event.key.toLowerCase();
  if(key == document.getElementById('display').innerText)
    score++;
}