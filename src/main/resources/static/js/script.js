document.addEventListener("DOMContentLoaded", () => {
    let currentTheme = localStorage.getItem("theme") || "light";
    applyTheme(currentTheme);

    document.getElementById("theme_change_button")?.addEventListener("click", toggleTheme);
});

function toggleTheme() {
    let currentTheme = document.documentElement.classList.contains("dark") ? "dark" : "light";
    let newTheme = currentTheme === "dark" ? "light" : "dark";

    applyTheme(newTheme);
}

function applyTheme(theme) {
    document.documentElement.classList.toggle("dark", theme === "dark");
    localStorage.setItem("theme", theme);

    // Update button text dynamically
    const button = document.getElementById("theme_change_button");
    if (button) {
        button.querySelector("span").textContent = theme === "light" ? "dark" : "light";
    }
}
