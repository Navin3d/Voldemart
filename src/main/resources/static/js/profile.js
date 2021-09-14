var dropm = document.querySelector(".label");
var dropc = document.querySelector("#def");
var img1 = document.querySelector(".imgp");
var img2 = document.querySelector(".bgi");
var bgi = document.querySelector(".edit");
var proi1 = document.querySelector(".imgb");
var proi2 = document.querySelector(".imgbg");
var position = document.querySelector("#ba i");
var allow = document.querySelector(".drop");

dropm.addEventListener("click", function () {
  if (dropc.classList.contains("hide")) {
    dropc.classList.add("show");
    dropc.classList.remove("hide");
  } else if (dropc.classList.contains("show")) {
    dropc.classList.add("hide");
    dropc.classList.remove("show");
  }
});
img1.addEventListener("click", function () {
  proi1.click();
});
bgi.addEventListener("click", function () {
  proi2.click();
});
proi1.addEventListener("change", function () {
  console.log(this.files);
  if (this.files && this.files[0]) {
    img1.src = URL.createObjectURL(this.files[0]);
  }
});
proi2.addEventListener("change", function () {
  if (this.files && this.files[0]) {
    img2.src = URL.createObjectURL(this.files[0]);
  }
});
console.log(position.innerHTML.toLowerCase());
if (position.innerHTML.toLowerCase() == "admin") {
  allow.classList.add("show");
} else {
  allow.classList.add("hide");
}
const d = new Date();
setInterval(function () {
  document.getElementById("tdate").innerHTML = d;
}, 1);
