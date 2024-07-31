
const productContainer = document.querySelector('.product-container');

fetch("http://localhost:8080/api/product")
    .then(response => response.json())
    .then(data => {
        console.log(data);
        productContainer.innerHTML = "";
        data.forEach((product, index) => {
            const productDiv = document.createElement('div');
            productDiv.classList.add('product');
            productDiv.innerHTML = `
                <img src="${product.imageFileName}" alt="${product.name}">
                <h3>${product.name}</h3>
                <h4>${product.price} "$"</h4>
                <p>${product.description}</p>
                <div class="cart">
                    <div class="number">
                        <button onclick="total(${index}, -1)">-</button>
                        <span class="num" id="num-${index}">0</span>
                        <button onclick="total(${index}, 1)">+</button>
                    </div>
                    <div class="addcart">
                        <button onclick="display(${index})">Add to Cart</button>
                    </div>
                </div>
            `;
            productContainer.appendChild(productDiv);
        });
    })
    .catch(error => console.log(error));

function total(index, num) {
    const value = document.getElementById(`num-${index}`);
    const sum = parseInt(value.innerHTML) + num;
    value.innerHTML = sum;
}


function display(index) {
    const quantity = document.getElementById(`num-${index}`).innerHTML;
    const title = document.querySelectorAll('.product h3')[index].innerHTML;
    const price = document.querySelectorAll('.product h4')[index].innerHTML.replace(" $", ""); // Extracting price
    const description = document.querySelectorAll('.product p')[index].innerHTML;

    const productDetails = {
        title: title,
        quantity: parseInt(quantity),
        price: parseFloat(price),
        description: description
    };

    fetch('http://localhost:8080/api/cart', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(productDetails),
    })
    .then(response => response.json())
    .then(data => {
        alert(`Product: ${title}\nQuantity: ${quantity} \n Added to cart`);
    })
    .catch(error => console.error('Error:', error));
}
