async function loadWords() {
    try {
        const response = await fetch('/api/words');
        const words = await response.json();
        renderTable(words);
    } catch (error) {
        console.error("Failed to fetch words:", error);
    }
}

function renderTable(words) {
    const tableBody = document.getElementById('vocabBody');
    tableBody.innerHTML = words.map(word => `
        <tr>
            <td class="kanji-cell">${word.kanji || 'ー'}</td>
            <td>${word.hiragana}</td>
            <td>${word.romaji}</td>
            <td class="english-cell">${word.english}</td>
        </tr>
    `).join('');
}

function searchTable() {
    const input = document.getElementById('searchInput').value.toLowerCase();
    const rows = document.querySelectorAll('#vocabBody tr');

    rows.forEach(row => {
        // This looks at the text in the whole row
        const text = row.textContent.toLowerCase();
        row.style.display = text.includes(input) ? '' : 'none';
    });
}

// Start
loadWords();