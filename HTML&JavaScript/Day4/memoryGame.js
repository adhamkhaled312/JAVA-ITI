document.addEventListener('DOMContentLoaded', () => {
  const symbols = ['🚗', '🚕', '🚌', '🚑', '🚓', '🚲'];
  const deck = [...symbols, ...symbols];

  const board = document.getElementById('game-board');
  const status = document.getElementById('status');

  let flipped = [];
  let matches = 0;
  shuffle(deck);
  deck.forEach((symbol, index) => {
    const card = document.createElement('div');
    card.dataset.symbol = symbol;
    card.dataset.index = index;

    card.style.width = '80px';
    card.style.height = '80px';
    card.style.background = '#ccc';
    card.style.cursor = 'pointer';
    card.style.fontSize = '40px';
    card.style.display = 'flex';
    card.style.alignItems = 'center';
    card.style.justifyContent = 'center';

    board.appendChild(card);
  });

  board.addEventListener('click', (e) => {
    const card = e.target;
    if (
      card === board ||
      card.innerText ||
      flipped.length >= 2
    ) return;

    card.innerText = card.dataset.symbol;
    card.style.background = 'white';
    flipped.push(card);

    if(flipped.length === 1)
    {
        const first = flipped[0];
        setTimeout(() => {
            if(!(flipped.length === 1 && flipped[0] == first))
            {
                return;
            }
          first.innerText = '';
          first.style.background = '#ccc';
          flipped = [];
        }, 2000);
    }
    if (flipped.length === 2) {
      const c1 = flipped[0];
      const c2 = flipped[1];

      if (c1.dataset.symbol === c2.dataset.symbol) {
        matches++;
        status.innerText = `Matches: ${matches}`;
        flipped = [];
        if(matches === 6)
        {
            alert("You Won");
            location.reload();
        }
      } else {
        setTimeout(() => {
          c1.innerText = '';
          c2.innerText = '';
          c1.style.background = '#ccc';
          c2.style.background = '#ccc';
          flipped = [];
        }, 1000);
      }
    }
  });
});
function shuffle(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
}