/**
 * 
 */
let qtys = document.getElementsByClassName("qty");
let updateQty = (e) => {
	const target = e.target;
	const { dataset } = target;
	const data = new FormData();
	data.append("pid", dataset.id);
	data.append("quantity", target.value);
	data.append("uri", "checkout-cart");
	data.append("xhr", true);
	const params = new URLSearchParams(data);
	fetch(`${dataset.ctx}/cart`, {
		method: "POST",
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: params
	}).then((response) => {
		if (!response.ok) {
			throw new Error('Network response was not OK');
		}
		return response.text();
	}).then((text) => {
		let totalSpan = document.getElementById("totalspan");
		totalSpan.innerHTML = text;
	}).catch(e => {
		console.log("Error", e);
	});

}
if (qtys) {
	for (let i = 0; i < qtys.length; i++) {
		qtys[i].addEventListener('change', updateQty, false);
	}

}
let deletes = document.getElementsByClassName("delete");
let deleteItem = (e) => {
	const target = e.target;
	const { dataset } = target;
	const data = new FormData();
	data.append("pid", dataset.id);
	data.append("xhr", true);
	const params = new URLSearchParams(data);
	fetch(`${dataset.ctx}/cart?${params}`, {
		method: "DELETE",
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
		},
	}).then(response => {
		if (!response.ok) {
			throw new Error('Network response was not OK');
		}
		window.location.href = `${dataset.ctx}/cart`;
	}).catch(e => {
		console.log("Error", e);
	});
}

if (deletes) {
	for (let i = 0; i < deletes.length; i++) {
		deletes[i].addEventListener('click', deleteItem, false);
	}

}
