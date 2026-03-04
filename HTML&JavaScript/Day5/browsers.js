        function addBrowser() {
            const input = document.getElementById('browserInput').value.trim();
            if (input === "") {
                alert("Please enter a browser name!");
                return;
            }

            const select = document.getElementById('browserList');
            const option = document.createElement("option");
            option.text = input;
            select.add(option);
            document.getElementById('browserInput').value = "";
        }

        function deleteBrowser() {
            const select = document.getElementById('browserList');
            const selectedIndex = select.selectedIndex;

            if (selectedIndex <= 0) {
                alert("Please select a browser to delete!");
                return;
            }

            select.remove(selectedIndex);
        }

        function updateInput() {
            const select = document.getElementById('browserList');
            const input = document.getElementById('browserInput');
            if (select.selectedIndex > 0) {
                input.value = select.options[select.selectedIndex].text;
            } else {
                input.value = "";
            }
        }