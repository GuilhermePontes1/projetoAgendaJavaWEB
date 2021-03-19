/**
 * @author Guilherme Pontes 
 */

function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value

	if (nome == "") {
		alert("Campo nome se encontra Vazio!!")
		frmContato.nome.focus()
		return false
	} else if (fone == "") {
		alert("Campo fone se econtra Vazio!!")
		frmContato.fone.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}