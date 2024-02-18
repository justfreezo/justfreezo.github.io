let calcScrollValue = () => {
    let scrollProgress = document.getElementById("progression");
    let progressValue = document.getElementById("valeur-progression");
    let pos = document.documentElement.scrollTop;
    let calcheight = document.documentElement.scrollHeight - document.documentElement.clientHeight;
    let scrollValue = Math.round((pos*100)/calcheight);
    if (pos > 100) {
        scrollProgress.style.display = "grid"
    }
    else{
        scrollProgress.style.display = "none"
    }
    scrollProgress.addEventListener("click", () => {document.documentElement.scrollTop = 0;});
    scrollProgress.style.background = `conic-gradient(#f1e173 ${scrollValue}%, #454545 ${scrollValue}%)`;
};

window.onscroll = calcScrollValue;
window.onload = calcScrollValue;
