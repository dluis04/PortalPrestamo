/*SCRIPT PARA PREVENIR QUE LA TECLA BACKSPACE FUNCIONE COMO BOTON BACK DEL NAVEGADOR*/
$(document).on("keydown", function (e) {
	if (e.which === 8 && !$(e.target).is("input:not([readonly]), textarea")) {
		e.preventDefault();
	}
});

//Libreria de Validaciones propiedad de J&VSoftware.
//Hecha el 13-04-2004 por el grupo de desarrollo de J&VSoftware Inc
/*Valida que una cadena solo contenga los caracteres de la variable validos*/
var formato = "yyyy-MM-dd";
var periodo = "yyyy-MM";

function refrescar() {
    document.forms["form1"].submit();
}




function cargarPantallaDinamica()
{
	doc= document.getElementById('form1:boton');
	doc.click();
}

function refreshConfiguracion() {
    document.forms["formConfiguracion"].submit();
}

function refrescarCampoCodigo() {
    document.forms["formularioConsultaAsginacion"].submit();
}

function setFormat(valorFormato)//define el formato a usar por la funcion isDate(val,format);
{
    formato = valorFormato;
}

function validarCaracteres(str) {
    var validos = " 1234567890abcdefghijklmn�opqrstuvwxyzABCDEFGHIJKLMN�OPQRSTUVWXYZ&'.()-_#%\/";
    for (var i = 0;i < str.length;i++) {
        if (validos.indexOf(str.charAt(i)) ==  - 1)
            return false;
    }
    return true;
}

// Metodo para validar numeros enteros Hecho por Alejandro.
function validarEnteros(str) {
    var validos = " 1234567890";
    var cad = "";
    // Si es un negativo ignoramos el signo y seguimos la comparacion
    if (str.charAt(0) == '-')
        cad = str.substring(1);
    else 
        cad = str;
    for (var i = 0;i < cad.length;i++) {
        if (validos.indexOf(cad.charAt(i)) ==  - 1)
            return false;
    }
    return true;
}

//Metodo valida que solo ingrese numeros enteros en un campo determinado
function validarEntero(obj, valor) {
    //intento convertir a entero. 
    //si era un entero no le afecta, si no lo era lo intenta convertir 
    valor = parseInt(valor)

    //Compruebo si es un valor num�rico 
    if (isNaN(valor)) {
        //entonces (no es numero) devuelvo el valor cadena vacia 
        obj.value = "";
    }
    else {
        //En caso contrario (Si era un n�mero) devuelvo el valor 
        //obj.value=valor;
    }
}

/*
* Metodo elaborado por Jorge Ivan Marmolejo
* Este metodo valida que la cadena tenga solo letras
*/
function validarSoloLetras(str) {
    var validos = " abcdefghijklmn�opqrstuvwxyzABCDEFGHIJKLMN�OPQRSTUVWXYZ";
    for (var i = 0;i < str.length;i++) {
        if (validos.indexOf(str.charAt(i)) ==  - 1)
            return false;
    }
    return true;
}

function validarClave(str) {
    var validos = "1234567890abcdefghijklmn�opqrstuvwxyzABCDEFGHIJKLMN�OPQRSTUVWXYZ���������� ";
    for (var i = 0;i < str.length;i++) {
        if (validos.indexOf(str.charAt(i)) ==  - 1)
            return true;
    }
    return false;
}

/*valida que el a�o sea mayor al siglo pasado*/
function y2k(number) {
    return (number < 1000) ? number + 1900 : number;
}

/*Valida que una fehca se valida*/
function FechaValida(dia, mes, anio) {
    // Verifica si una fecha es valida
    var hoy = new Date();
    anio = ((!anio) ? y2k(today.getYear()) : anio);
    mes = ((!mes) ? today.getMonth() : mes - 1);
    if (!dia)
        return false
    var test = new Date(anio, mes, dia);
    if ((y2k(test.getYear()) == anio) && (mes == test.getMonth()) && (dia == test.getDate()))
        return true;
    else 
        return false
}

/*quita los espacios al lado de una cadena */
function LTrim(str) {
    var whitespace = new String(" \t\n\r");

    var s = new String(str);

    if (whitespace.indexOf(s.charAt(0)) !=  - 1) {

        var j = 0, i = s.length;

        while (j < i && whitespace.indexOf(s.charAt(j)) !=  - 1)
            j++;

        s = s.substring(j, i);
    }
    return s;
}

function RTrim(str) {
    var whitespace = new String(" \t\n\r");

    var s = new String(str);

    if (whitespace.indexOf(s.charAt(s.length - 1)) !=  - 1) {
        var i = s.length - 1;
        while (i >= 0 && whitespace.indexOf(s.charAt(i)) !=  - 1)
            i--;

        s = s.substring(0, i + 1);
    }

    return s;
}
/*quita esocios de la cadena a la derecha y a la izquierda*/
function Trim(str) {
    return RTrim(LTrim(str));
}

/*escribe la fecha actual*/
function fecha() {
    var mydate = new Date()
    var year = mydate.getYear()
    if (year < 1000)
        year += 1900
    var day = mydate.getDay()
    var month = mydate.getMonth()
    var daym = mydate.getDate()
    if (daym < 10)
        daym = "0" + daym
    var dayarray = new Array("Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado")
    var montharray = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
    document.write("" + dayarray[day] + " " + daym + " de " + montharray[month] + " de " + year + "")
}

/*busca un objeto dentro del documento*/
function BuscarObjeto(n, d) {
    //v4.01
    var p, i, x;
    if (!d)
        d = document;
    if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
        d = parent.frames[n.substring(p + 1)].document;
        n = n.substring(0, p);
    }
    if (!(x = d[n]) && d.all)
        x = d.all[n];
    for (i = 0;!x && i < d.forms.length;i++)
        x = d.forms[i][n];
    for (i = 0;!x && d.layers && i < d.layers.length;i++)
        x = BuscarObjeto(n, d.layers[i].document);
    if (!x && d.getElementById)
        x = d.getElementById(n);
    return x;
}

/*compara fechas ... fecha1 vs fecha2 segun el parametro Compara*/
function CompararFechas(Fecha1, DescFecha1, Fecha2, DescFecha2, Compara) {

    if (Compara == "<") {
        if (Fecha1 > Fecha2) {
            alert(DescFecha1 + " debe ser menor a " + DescFecha2);
            return false;
        }
    }
    else if (Compara == ">") {
        if (Fecha1 < Fecha2) {
            alert(DescFecha1 + " debe ser mayor a " + DescFecha2);
            return false;
        }
    }
    else if (Compara == "=") {
        if (Fecha1 != Fecha2) {
            alert(DescFecha1 + " debe ser igual a " + DescFecha2);
            return false;
        }
    }
    return true;
}
//Hecho por Diego Armando Gomez diegomez@jvsoftware.com
//Metodo para saber si una fecha es mayor a la del dia
//Fecha yyyy-mm-dd	2004-12-24
//Retorna Verdadero si la fecha es menor a la del dia.
//Retorna Falso si la fecha es mayor a la del dia.
function fechaMayorHoy(fecha) {
    var stringDate = fecha.split("-");
    var yyyy = stringDate[0];
    var mm = stringDate[1];
    var dd = stringDate[2];
    var hoy = new Date();
    var date = new Date(yyyy, (mm - 1), dd);
    if (date.getTime() > hoy.getTime()) {
        return false;
    }
    else {
        return true;
    }
}
//M�todo que permite Quitar los espacios en blanco a los lados en las formas que tiene campos de tipo texto
//Hecho Por Diego Gomez diegomez@jvsoftware.com
function clearFormSpace() {
    var forma = window.document.forms[0]
    for (var i = 0;i < forma.elements.length;i++) {
        if (forma.elements[i].type == "text" || forma.elements[i].type == "textArea") {
            forma.elements[i].value = Trim(forma.elements[i].value);
        }
    }
}
//M�todo que permite saber en un combo se selecciono una opcion si es -1 no se selecciono
//Hecho Por Diego Gomez diegomez@jvsoftware.com
function isComboSelect() {
    var forma = window.document.forms[0]
    for (var i = 0;i < forma.elements.length;i++) {
        if (forma.elements[i].type == "select") {
            if (forma.elements[i].value == "-1") {
                return false;
            }
        }
    }
    return true;
}

/*
* Metodo elaborado por Jorge Ivan Marmolejo
* Este metodo valida si una cadena es numerica tipo entero y de signo positivo
*/
function isNumericIntPositivo(str) {
    var validos = "0123456789";
    for (var i = 0;i < str.length;i++) {
        if (validos.indexOf(str.charAt(i)) ==  - 1)
            return false;
    }
    return true;
}

function isComboFull(val) {

    if (val.length == 0)
        return false
    else 
        return true
}

/* 
* Metodo para validar si una cadena n�merica tipo flotante es positiva
* Elaborado por Jorge Hern�n V�lez Modificada por Alejandro Alvarez, para validar que sea flotante.
*/
function isNumericPositivo(str) {
    var contador = 0;
    var validos = "0123456789.";
    for (var i = 0;i < str.length;i++) {
        if (validos.indexOf(str.charAt(i)) ==  - 1)
            return false;
        // validamos que sea decimal.
        else if (str.charAt(i) == ".") {
            contador++;
            if (i == 0 || i == str.length - 1)
                return false;
        }

    }
    if (contador > 1)
        return false;// habia mas de 1 punto en la cadena str.
    return true;
    /*
    for (var i=0; i< str.length; i++) {
       if (str.charAt(i) == "-")
          return false;
    }
    return true;*/
}
/*
* Metodo elaborado por Jorge Ivan Marmolejo
* Este metodo valida si una cadena es numerica
*/
function isNumeric(str) {
    var num = parseFloat(str);
    if (isNaN(num))
        return false
    else 
        return true

}

// Para validar numeros enteros positivos : isPositivo 
// Para validar Requerido : R
// Para validar que sea entero : isInteger
// Para valida Email : isEmail
// Para Validar Solo Numeros : isNaN
// Para Validar Solo Letras : isLetter
// Para Validar Solo Numeros y Rango : inRange  ej.: inRange1:21  Lo anterior es Rango de 1 hasta 21
// Para Validar Solo Numeros y Consistencia Decimal : validarDecimales  ej.: validarDecimales8:2  Lo anterior es validar que el decimal tenga 8 digitos enteros y 2 decimales
// Para validar caracteres especiales : isEspecial
// Para validar si es la fecha actual: isFechaActual
// Para validar si es password: isPassword
// Para validar un radiobutton : isCheck
// Para validar un combos : isCombo
// Para Validar fecha menor a la del dia : isFechaMayorHoy
// Para Validar fecha mayor a la del dia : isFechaMenorHoy
// Para validar fecha o periodo con un determinado formato: isDFormat ej: isDFormat:yyyy-MM
// Para validar periodo: isPeriod
// Para validar periodo mayor al actual: isPeMayorActual
// Para validar numeros positivos en  : isPositive 
function ValidaForma() {
    //v4.0
    //diegomez@jvsoftware.com
    clearFormSpace();
    transformToUpperCase();//transforma los campos a may�sculas,jmduran@jvsoftware.com
    //isNumericIntPositivo(str);
    var i, p, r, q, nm, test, num, min, max, dateFormat, errors = '', args = ValidaForma.arguments;
    for (i = 0;i < (args.length - 2);i += 3) {
        test = args[i + 2];
        val = BuscarObjeto(args[i]);
        if (val) {
            var valTemp = val;
            nm = args[i + 1];//nm = fncNombresCampos(val.name);
            if ((val = val.value) != "") {
                val = Trim(val);
                if (val.length == 0)
                    errors += '- ' + nm + ' es requerido.\n';

                if (test.indexOf('isEmail') !=  - 1) {
                    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                    var bandera = patron.test(val);
                    if (bandera == false) {
                        errors += '- ' + nm + ' debe contener una direcci�n de email v�lida.\n';
                    }
                }
                else if (test.indexOf('isDate') !=  - 1) {
                    var bandera = isDate(val);
                    if (bandera == false) {
                        errors += '- ' + nm + ' debe ser una fecha v�lida entre el a�o 1700 y 2300.\n';
                    }
                }
                else if (test.indexOf('isComboLleno') !=  - 1) {
                    if (!isComboFull(val))
                        errors += '- ' + nm + ' Error.\n';
                }

                else if (test.indexOf('isDFormat') !=  - 1) {
                    p = test.indexOf(':');
                    dateFormat = test.substring(p + 1);
                    var bandera = isDateFormat(val, dateFormat);
                    if (bandera == false) {
                        errors += '- ' + nm + ' no tiene un formato v�lido.\n';
                    }
                }
                else if (test.indexOf('isPeriod') !=  - 1) {
                    p = test.indexOf(':');
                    if (p < 0)//si no se envio el formato del periodo
                        dateFormat = periodo;
                    else 
                        dateFormat = test.substring(p + 1);
                    var bandera = isDateFormat(val, dateFormat);
                    if (bandera == false) {
                        errors += '- ' + nm + ' no tiene el formato ' + dateFormat.toUpperCase() + ' .\n';
                    }
                }
                else if (test.indexOf('isMoney') !=  - 1)//valida si el formato es moneda
                {
                    var bandera = validarMoneda(val);
                    if (bandera == false) {
                        errors += '- ' + nm + ' debe ser un formato de moneda v�lido.\n';
                    }
                }

                else if (test.indexOf('isLetter') !=  - 1)//JD
                {
                    var bandera = validarSoloLetras(val);
                    if (bandera == false) {
                        errors += '- ' + nm + ' debe contener solo letras.\n';
                    }
                }

                else if (test.indexOf('isCheck') !=  - 1) {
                    var icheck, swcheck = 0;
                    for (icheck = 0;icheck < valTemp.length;icheck++) {
                        if (valTemp[icheck].checked == true) {
                            swcheck = 1;
                            break;
                        }
                    }
                    if (swcheck == 0) {
                        errors += '- ' + nm + ' requiere seleccionar una opci�n.\n';
                    }
                }
                else if (test.indexOf('isCombo') !=  - 1) {
                    if (val == "-1")
                        errors += '- ' + nm + ' no se seleccion�.\n';

                }
                else if (test.indexOf('isEspecial') !=  - 1 || test.indexOf('isNotNum') !=  - 1) {
                    if (test.indexOf('isEspecial') !=  - 1) {
                        if (!validarCaracteres(val))
                            errors += '- ' + nm + ' contiene caracteres con tildes o caracteres no v�lidos .\n';
                    }

                    if (test.indexOf('isNotNum') !=  - 1) {
                        num = parseFloat(val);
                        if (!isNaN(num))
                            errors += '- ' + nm + ' NO debe contener solo n�meros.\n';
                    }

                }
                else if (test.indexOf('isPassword') !=  - 1) {
                    if (!validarClave(val))
                        errors += '- ' + nm + ' contiene caracteres no v�lidos.\n';
                }
                else if (test.indexOf('isPeMayorActual') !=  - 1) {
                    val = val + "-01";
                    var bien = fechaMayorHoy(val);
                    if (bien == false) {
                        errors += '- ' + nm + ' debe ser menor que la fecha actual.\n';
                    }
                }
                else if (test.indexOf('isPeMenorActual') !=  - 1) {
                    val = val + "-01";
                    var bien = fechaMayorHoy(val);
                    if (bien == true) {
                        errors += '- ' + nm + ' debe ser mayor que la fecha actual.\n';
                    }
                }
                else if (test.indexOf('isFechaMayorHoy') !=  - 1) {
                    var bien = fechaMayorHoy(val);
                    if (bien == false) {
                        errors += '- ' + nm + ' debe ser menor que la fecha actual.\n';
                    }
                }
                else if (test.indexOf('isFechaMenorHoy') !=  - 1) {
                    var bien = fechaMayorHoy(val);
                    if (bien == true) {
                        errors += '- ' + nm + ' debe ser mayor que la fecha actual.\n';
                    }
                }
                else if (test.indexOf('isPositivo') !=  - 1) {
                    if (!isNumericIntPositivo(val))
                        errors += '- ' + nm + ' debe ser n�mero entero positivo.\n';
                }
                else if (test.indexOf('isInteger') !=  - 1) {
                    if (!validarEnteros(val))
                        errors += '- ' + nm + ' debe contener n�meros enteros.\n';
                }
                else if (test.indexOf('isPositive') !=  - 1) {
                    if (!isNumericPositivo(val))
                        errors += '- ' + nm + ' debe contener n�meros positivos.\n';
                }
                else if (test.indexOf('validarDecimales') !=  - 1)// Adicionado por Alejandro para validar consistencia de campos decimales con la base de datos.
                {
                    p = test.indexOf(':');
                    enteros = test.substring(16, p);// guardamos la cantidad de enteros que permite almacenar la base de datos
                    decimales = test.substring(p + 1);// guardamos la cantidad de decimales que permite almacenar la base de datos
                    if (isNumeric(val)) {
                        punto = val.indexOf('.');
                        var coma = val.indexOf(',');
                        if (coma !=  - 1 && punto < 0)
                            errors += '- ' + nm + ' debe separar su parte decimal con punto no con coma.\n';
                        else if (punto !=  - 1)// si vienen decimales validamos que traiga la cantidad correcta
                        {
                            var parteEntera = val.substring(0, punto);// guardamos la parte entera
                            var parteDecimal = val.substring(punto + 1);// guardamos la parte decimal
                            if (parteEntera.length > enteros) {
                                errors += '- ' + nm + ' debe contener un m�ximo de ' + enteros + ' digitos enteros y ' + decimales + ' decimales.\n';
                            }
                        }
                        else if (val.length > enteros)
                            errors += '- ' + nm + ' debe contener un m�ximo de ' + enteros + ' digitos enteros y ' + decimales + ' decimales.\n';
                    }
                    else 
                        errors += '- ' + nm + ' debe ser un n�mero con un m�ximo de ' + enteros + ' digitos enteros y ' + decimales + ' decimales.\n';
                }
                else if (test != 'R') {
                    num = parseFloat(val);
                    if (isNaN(val))
                        errors += '- ' + nm + ' debe contener solo n�meros.\n';
                    if (test.indexOf('isMayor') !=  - 1) {
                        num = parseFloat(val);
                        p = test.indexOf(':');
                        min = test.substring(p + 1);
                        if (num <= min)
                            errors += '- ' + nm + ' debe contener n�meros mayores a ' + min + '\n';
                    }
                    if (test.indexOf('inRange') !=  - 1) {
                        p = test.indexOf(':');
                        min = test.substring(8, p);
                        max = test.substring(p + 1);
                        if (num < min || max < num)
                            errors += '- ' + nm + ' debe contener solo n�meros entre ' + min + ' y ' + max + '.\n';
                    }
                }
            }
            else if (test.charAt(0) == 'R')
                errors += '- ' + nm + ' es requerido.\n';
        }
    }
    if (errors) {
        alert('Se presentaron los siguientes errores:\n' + errors);
        return false;
    }
    else {
        return true;
    }
}

/////////////////////funciones para validar fechas
// ===================================================================
// Author: Matt Kruse <matt@mattkruse.com>
// WWW: http://www.mattkruse.com/
//
// NOTICE: You may use this code for any purpose, commercial or
// private, without any further permission from the author. You may
// remove this notice from your final code if you wish, however it is
// appreciated by the author if at least my web site address is kept.
//
// You may *NOT* re-distribute this code in any way except through its
// use. That means, you can include it in your product, or your web
// site, or any other form where the code is actually being used. You
// may not put the plain javascript up on your site for download or
// include it in your javascript libraries for download. 
// If you wish to share this code with others, please just point them
// to the URL instead.
// Please DO NOT link directly to my .js files from your site. Copy
// the files to your server and use them there. Thank you.
// ===================================================================
// HISTORY
// ------------------------------------------------------------------
// May 17, 2003: Fixed bug in parseDate() for dates <1970
// March 11, 2003: Added parseDate() function
// March 11, 2003: Added "NNN" formatting option. Doesn't match up
//                 perfectly with SimpleDateFormat formats, but 
//                 backwards-compatability was required.
// ------------------------------------------------------------------
// These functions use the same 'format' strings as the 
// java.text.SimpleDateFormat class, with minor exceptions.
// The format string consists of the following abbreviations:
// 
// Field        | Full Form          | Short Form
// -------------+--------------------+-----------------------
// Year         | yyyy (4 digits)    | yy (2 digits), y (2 or 4 digits)
// Month        | MMM (name or abbr.)| MM (2 digits), M (1 or 2 digits)
//              | NNN (abbr.)        |
// Day of Month | dd (2 digits)      | d (1 or 2 digits)
// Day of Week  | EE (name)          | E (abbr)
// Hour (1-12)  | hh (2 digits)      | h (1 or 2 digits)
// Hour (0-23)  | HH (2 digits)      | H (1 or 2 digits)
// Hour (0-11)  | KK (2 digits)      | K (1 or 2 digits)
// Hour (1-24)  | kk (2 digits)      | k (1 or 2 digits)
// Minute       | mm (2 digits)      | m (1 or 2 digits)
// Second       | ss (2 digits)      | s (1 or 2 digits)
// AM/PM        | a                  |
//
// NOTE THE DIFFERENCE BETWEEN MM and mm! Month=MM, not mm!
// Examples:
//  "MMM d, y" matches: January 01, 2000
//                      Dec 1, 1900
//                      Nov 20, 00
//  "M/d/yy"   matches: 01/20/00
//                      9/2/00
//  "MMM dd, yyyy hh:mm:ssa" matches: "January 01, 2000 12:30:45AM"
// ------------------------------------------------------------------
var MONTH_NAMES = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December', 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec');
var DAY_NAMES = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');

function LZ(x) {
    return (x < 0 || x > 9 ? "" : "0") + x
}

// ------------------------------------------------------------------
// isDate ( date_string, format_string )
// Returns true if date string matches format of format string and
// is a valid date. Else returns false.
// It is recommended that you trim whitespace around the value before
// passing it to this function, as whitespace is NOT ignored!
// ------------------------------------------------------------------
function isDate(val) {
    //si no recibe el formato lo toma de la variable global formato.Nota: Debe inicializarse esta variabl�e a trav�s del metodo setFormat
    // Modificado por Alejandro Alvarez para validar que las fechas validas esten unicamente entre el a�o 1900 y 2200.
    var stringDate = val.split("-");
    if (parseInt(stringDate[0]) < 1700 || parseInt(stringDate[0]) > 2300)
        return false;
    var date = getDateFromFormat(val, formato);
    if (date == 0) {
        return false;
    }
    return true;
}

// -------------------------------------------------------------------
// compareDates(date1,date1format,date2,date2format)
//   Compare two date strings to see which is greater.
//   Returns:
//   1 if date1 is greater than date2
//   0 if date2 is greater than date1 of if they are the same
//  -1 if either of the dates is in an invalid format
// -------------------------------------------------------------------
function compareDates(date1, dateformat1, date2, dateformat2) {
    var d1 = getDateFromFormat(date1, dateformat1);
    var d2 = getDateFromFormat(date2, dateformat2);
    if (d1 == 0 || d2 == 0) {
        return  - 1;
    }
    else if (d1 > d2) {
        return 1;
    }
    return 0;
}

// ------------------------------------------------------------------
// formatDate (date_object, format)
// Returns a date in the output format specified.
// The format string uses the same abbreviations as in getDateFromFormat()
// ------------------------------------------------------------------
function formatDate(date, format) {
    format = format + "";
    var result = "";
    var i_format = 0;
    var c = "";
    var token = "";
    var y = date.getYear() + "";
    var M = date.getMonth() + 1;
    var d = date.getDate();
    var E = date.getDay();
    var H = date.getHours();
    var m = date.getMinutes();
    var s = date.getSeconds();
    var yyyy, yy, MMM, MM, dd, hh, h, mm, ss, ampm, HH, H, KK, K, kk, k;
    // Convert real date parts into formatted versions
    var value = new Object();
    if (y.length < 4) {
        y = "" + (y - 0 + 1900);
    }
    value["y"] = "" + y;
    value["yyyy"] = y;
    value["yy"] = y.substring(2, 4);
    value["M"] = M;
    value["MM"] = LZ(M);
    value["MMM"] = MONTH_NAMES[M - 1];
    value["NNN"] = MONTH_NAMES[M + 11];
    value["d"] = d;
    value["dd"] = LZ(d);
    value["E"] = DAY_NAMES[E + 7];
    value["EE"] = DAY_NAMES[E];
    value["H"] = H;
    value["HH"] = LZ(H);
    if (H == 0) {
        value["h"] = 12;
    }
    else if (H > 12) {
        value["h"] = H - 12;
    }
    else {
        value["h"] = H;
    }
    value["hh"] = LZ(value["h"]);
    if (H > 11) {
        value["K"] = H - 12;
    }
    else {
        value["K"] = H;
    }
    value["k"] = H + 1;
    value["KK"] = LZ(value["K"]);
    value["kk"] = LZ(value["k"]);
    if (H > 11) {
        value["a"] = "PM";
    }
    else {
        value["a"] = "AM";
    }
    value["m"] = m;
    value["mm"] = LZ(m);
    value["s"] = s;
    value["ss"] = LZ(s);
    while (i_format < format.length) {
        c = format.charAt(i_format);
        token = "";
        while ((format.charAt(i_format) == c) && (i_format < format.length)) {
            token += format.charAt(i_format++);
        }
        if (value[token] != null) {
            result = result + value[token];
        }
        else {
            result = result + token;
        }
    }
    return result;
}
// ------------------------------------------------------------------
// isDateFormat (date_object, format)
// Retorna true si una fecha corresponde al formato dado
// ------------------------------------------------------------------
function isDateFormat(val, format) {
    var date = getDateFromFormat(val, format);
    if (date == 0) {
        return false;
    }
    return true;
}

// ------------------------------------------------------------------
// Utility functions for parsing in getDateFromFormat()
// ------------------------------------------------------------------
function _isInteger(val) {
    var digits = "1234567890";
    for (var i = 0;i < val.length;i++) {
        if (digits.indexOf(val.charAt(i)) ==  - 1) {
            return false;
        }
    }
    return true;
}

function _getInt(str, i, minlength, maxlength) {
    for (var x = maxlength;x >= minlength;x--) {
        var token = str.substring(i, i + x);
        if (token.length < minlength) {
            return null;
        }
        if (_isInteger(token)) {
            return token;
        }
    }
    return null;
}

// ------------------------------------------------------------------
// getDateFromFormat( date_string , format_string )
//
// This function takes a date string and a format string. It matches
// If the date string matches the format string, it returns the 
// getTime() of the date. If it does not match, it returns 0.
// ------------------------------------------------------------------
function getDateFromFormat(val, format) {
    val = val + "";
    format = format + "";
    var i_val = 0;
    var i_format = 0;
    var c = "";
    var token = "";
    var token2 = "";
    var x, y;
    var now = new Date();
    var year = now.getYear();
    var month = now.getMonth() + 1;
    var date = 1;
    var hh = now.getHours();
    var mm = now.getMinutes();
    var ss = now.getSeconds();
    var ampm = "";

    while (i_format < format.length) {
        // Get next token from format string
        c = format.charAt(i_format);
        token = "";
        while ((format.charAt(i_format) == c) && (i_format < format.length)) {
            token += format.charAt(i_format++);
        }
        // Extract contents of value based on format token
        if (token == "yyyy" || token == "yy" || token == "y") {
            if (token == "yyyy") {
                x = 4;
                y = 4;
            }
            if (token == "yy") {
                x = 2;
                y = 2;
            }
            if (token == "y") {
                x = 2;
                y = 4;
            }
            year = _getInt(val, i_val, x, y);
            if (year == null) {
                return 0;
            }
            i_val += year.length;
            if (year.length == 2) {
                if (year > 70) {
                    year = 1900 + (year - 0);
                }
                else {
                    year = 2000 + (year - 0);
                }
            }
        }
        else if (token == "MMM" || token == "NNN") {
            month = 0;
            for (var i = 0;i < MONTH_NAMES.length;i++) {
                var month_name = MONTH_NAMES[i];
                if (val.substring(i_val, i_val + month_name.length).toLowerCase() == month_name.toLowerCase()) {
                    if (token == "MMM" || (token == "NNN" && i > 11)) {
                        month = i + 1;
                        if (month > 12) {
                            month -= 12;
                        }
                        i_val += month_name.length;
                        break;
                    }
                }
            }
            if ((month < 1) || (month > 12)) {
                return 0;
            }
        }
        else if (token == "EE" || token == "E") {
            for (var i = 0;i < DAY_NAMES.length;i++) {
                var day_name = DAY_NAMES[i];
                if (val.substring(i_val, i_val + day_name.length).toLowerCase() == day_name.toLowerCase()) {
                    i_val += day_name.length;
                    break;
                }
            }
        }
        else if (token == "MM" || token == "M") {
            month = _getInt(val, i_val, token.length, 2);
            if (month == null || (month < 1) || (month > 12)) {
                return 0;
            }
            i_val += month.length;
        }
        else if (token == "dd" || token == "d") {
            date = _getInt(val, i_val, token.length, 2);
            if (date == null || (date < 1) || (date > 31)) {
                return 0;
            }
            i_val += date.length;
        }
        else if (token == "hh" || token == "h") {
            hh = _getInt(val, i_val, token.length, 2);
            if (hh == null || (hh < 1) || (hh > 12)) {
                return 0;
            }
            i_val += hh.length;
        }
        else if (token == "HH" || token == "H") {
            hh = _getInt(val, i_val, token.length, 2);
            if (hh == null || (hh < 0) || (hh > 23)) {
                return 0;
            }
            i_val += hh.length;
        }
        else if (token == "KK" || token == "K") {
            hh = _getInt(val, i_val, token.length, 2);
            if (hh == null || (hh < 0) || (hh > 11)) {
                return 0;
            }
            i_val += hh.length;
        }
        else if (token == "kk" || token == "k") {
            hh = _getInt(val, i_val, token.length, 2);
            if (hh == null || (hh < 1) || (hh > 24)) {
                return 0;
            }
            i_val += hh.length;
            hh--;
        }
        else if (token == "mm" || token == "m") {
            mm = _getInt(val, i_val, token.length, 2);
            if (mm == null || (mm < 0) || (mm > 59)) {
                return 0;
            }
            i_val += mm.length;
        }
        else if (token == "ss" || token == "s") {
            ss = _getInt(val, i_val, token.length, 2);
            if (ss == null || (ss < 0) || (ss > 59)) {
                return 0;
            }
            i_val += ss.length;
        }
        else if (token == "a") {
            if (val.substring(i_val, i_val + 2).toLowerCase() == "am") {
                ampm = "AM";
            }
            else if (val.substring(i_val, i_val + 2).toLowerCase() == "pm") {
                ampm = "PM";
            }
            else {
                return 0;
            }
            i_val += 2;
        }
        else {
            if (val.substring(i_val, i_val + token.length) != token) {
                return 0;
            }
            else {
                i_val += token.length;
            }
        }
    }
    // If there are any trailing characters left in the value, it doesn't match
    if (i_val != val.length) {
        return 0;
    }
    // Is date valid for month?
    if (month == 2) {
        // Check for leap year
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            // leap year
            if (date > 29) {
                return 0;
            }
        }
        else {
            if (date > 28) {
                return 0;
            }
        }
    }
    if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
        if (date > 30) {
            return 0;
        }
    }
    // Correct hours value
    if (hh < 12 && ampm == "PM") {
        hh = hh - 0 + 12;
    }
    else if (hh > 11 && ampm == "AM") {
        hh -= 12;
    }
    var newdate = new Date(year, month - 1, date, hh, mm, ss);
    return newdate.getTime();
}

// ------------------------------------------------------------------
// parseDate( date_string [, prefer_euro_format] )
//
// This function takes a date string and tries to match it to a
// number of possible date formats to get the value. It will try to
// match against the following international formats, in this order:
// y-M-d   MMM d, y   MMM d,y   y-MMM-d   d-MMM-y  MMM d
// M/d/y   M-d-y      M.d.y     MMM-d     M/d      M-d
// d/M/y   d-M-y      d.M.y     d-MMM     d/M      d-M
// A second argument may be passed to instruct the method to search
// for formats like d/M/y (european format) before M/d/y (American).
// Returns a Date object or null if no patterns match.
// ------------------------------------------------------------------
function parseDate(val) {
    var preferEuro = (arguments.length == 2) ? arguments[1] : false;
    generalFormats = new Array('y-M-d', 'MMM d, y', 'MMM d,y', 'y-MMM-d', 'd-MMM-y', 'MMM d');
    monthFirst = new Array('M/d/y', 'M-d-y', 'M.d.y', 'MMM-d', 'M/d', 'M-d');
    dateFirst = new Array('d/M/y', 'd-M-y', 'd.M.y', 'd-MMM', 'd/M', 'd-M');
    var checkList = new Array('generalFormats', preferEuro ? 'dateFirst' : 'monthFirst', preferEuro ? 'monthFirst' : 'dateFirst');
    var d = null;
    for (var i = 0;i < checkList.length;i++) {
        var l = window[checkList[i]];
        for (var j = 0;j < l.length;j++) {
            d = getDateFromFormat(val, l[j]);
            if (d != 0) {
                return new Date(d);
            }
        }
    }
    return null;
}

function validaHorMin(hor, min) {
    if (hor > 23 || hor < 0 || min > 59 || min < 0)
        return false;
    else 
        return true;
}

//Funcion que coloca todos los campos de la forma que esten disabled o readonly con color de fondo gris
//Hecho por JEFFER MILLER DURAN 14-OCT-2004
function validarMoneda(valor) {
    // matches 17.23 or 14,281,545.45 or ...
    var patron = /\d{1,3}(,\d{3})*\.\d{2}/;
    var bandera = patron.test(val);
    return validarMoneda;

}

//Funcion que coloca todos los campos de la forma que esten disabled o readonly con color de fondo gris
//Hecho por JEFFER MILLER DURAN 08-OCT-2004
//Nota:funciona si la pagina no tiene el llamaado a la funcion onLoad en el body ej <body onLoad=funcion() >
function addLoadEvent(func) {
    var oldonload = window.onload;

    if (typeof window.onload != 'function') {
        window.onload = func;
    }
    else {
        window.onload = function () {
            oldonload();
            func();
        }

    }
}

function aplicarFormato() {
    i = 0;
    while (document.forms[i]) {
        if (document.forms[i] != null) {
            for (var j = 0;j < document.forms[i].elements.length;j++) {
                if (document.forms[i].elements[j].type == "text" || document.forms[i].elements[j].type == "textarea") {
                    if (document.forms[i].elements[j].disabled == true || document.forms[i].elements[j].readOnly == true) {
                        //document.forms[i].elements[j].style.fontWeight='600';
                        document.forms[i].elements[j].style.background = '#FFFFFF';
                    }
                    else {
                        document.forms[i].elements[j].style.background = '#EBEBEB';
                        //document.forms[i].elements[j].style.fontWeight='600';         
                    }
                }
                //el resto de objetos solo tienen el atributo disabled no tienen readonly
                else if (document.forms[i].elements[j].type == "select" || document.forms[i].elements[j].type == "checkbox" || document.forms[i].elements[j].type == "radio") {
                    if (document.forms[i].elements[j].disabled == true)
                        document.forms[i].elements[j].style.background = '#FFFFFF';
                    else 
                        document.forms[i].elements[j].style.background = '#EBEBEB';
                }
            }
        }
        i++;
    }
    //fin while
}

function aplicarFormatoTR(tr) {
    if (tr != null) {
        for (var k = 0;k < tr.childNodes.length;k++) {

            var elemento = tr.childNodes[k].firstChild;
            if (elemento.type == "text" || elemento.type == "textarea") {
                if (elemento.disabled == true || elemento.readOnly == true) {
                    //document.forms[i].elements[j].style.fontWeight='600';
                    elemento.style.background = '#FFFFFF';
                }
                else {
                    elemento.style.background = '#EBEBEB';
                    //document.forms[i].elements[j].style.fontWeight='600';         
                }
            }
            //el resto de objetos solo tienen el atributo disabled no tienen readonly
            else if (elemento.type == "select" || elemento.type == "checkbox" || elemento.type == "radio") {
                if (elemento.disabled == true)
                    elemento.style.background = '#FFFFFF';
                else 
                    elemento.style.background = '#F2F9FF';
            }

        }
    }
}

addLoadEvent(function () {
    aplicarFormato();
})

//M�todo que permite deshabilitar o habilitar todos campos de tipo texto de una forma
//Hecho Por Jesus David Mojarrango jdmoja@jvsoftware.com
function enableFormText(accion) {
    var forma = window.document.forms[0]
    for (var i = 0;i < forma.elements.length;i++) {
        if (forma.elements[i].type == "text" || forma.elements[i].type == "textArea") {
            forma.elements[i].disabled = accion;
        }
    }
}

//Funci�n que transforma los datos en May�sculas a aquellos campos que tengan la clase SnowInput, al resto no les hace nada
//Hecho por Jeffer Miller Duran 17-Nov-2004
function transformToUpperCase() {
    i = 0;
    while (document.forms[i]) {
        if (document.forms[i] != null) {
            var forma = window.document.forms[i]
            for (var j = 0;j < forma.elements.length;j++) {
                if (forma.elements[j].type != null && (forma.elements[j].type == "text" || forma.elements[j].type.toLowerCase() == "textarea")) {
                    if (forma.elements[j].className == 'SnowInput') {
                        forma.elements[j].value = forma.elements[j].value.toUpperCase();
                    }
                }
            }
        }
        i++;
    }
    //fin while
}

//Funcion para convertir una cadena en formato numerico
function formatCurrency(obj, num, signo, ctvs) {
    num = num.toString().replace(/\$|\,/g, '');
    if (isNaN(num))
        num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 100 + 0.50000000001);
    cents = num % 100;
    num = Math.floor(num / 100).toString();
    if (cents < 10)
        cents = "0" + cents;
    for (var i = 0;i < Math.floor((num.length - (1 + i)) / 3);i++)
        num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
    if (ctvs == 'true') {
        obj.value = (((sign) ? '' : '-') + signo + num + '.' + cents);
    }
    else {
        obj.value = (((sign) ? '' : '-') + signo + num);
    }

    //obj.value= (((sign)?'':'-') + signo + num);
}

//funcion que valida que un campo debe contener solo letras
function solo_letras(f) {
    if (f.value.match(/[^a-z\ ]/)) {
        f.value = f.value.replace(/[^a-z\ ]/gi, "")
    }

}

//Disable right mouse click Script
//By Maximus (maximus@nsimail.com) w/ mods by DynamicDrive
//For full source code, visit http://www.dynamicdrive.com
/*
var message="Funci�n Deshabilitada!";

///////////////////////////////////
function clickIE4(){
if (event.button==2){
alert(message);
return false;
}
}

function clickNS4(e){
if (document.layers||document.getElementById&&!document.all){
if (e.which==2||e.which==3){
alert(message);
return false;
}
}
}

if (document.layers){
document.captureEvents(Event.MOUSEDOWN);
document.onmousedown=clickNS4;
}
else if (document.all&&!document.getElementById){
document.onmousedown=clickIE4;
}
document.oncontextmenu=new Function("alert(message);return false")
*/
//Coloca la rura en el titulo de la ventana, esto para saber donde esta ubicado el usuario
if (parent == null)
    document.title = "Psicovirtual";//si es una pagina sola
else if (parent.parent != null)
    parent.parent.document.title = "Psicovirtual";//si es una p�gina dentro de 2 frames
else 
    parent.document.title = "Psicovirtual";//si es una p�gina dentro de 1 frame
//Metodo encargado de validar cada vez que se cambie el valor del cupo padre que sea numerico, y si es superior a la suma de los valores de los cupos hijos
function validarValorCupoPadre(obj) {
    try {
        //Se determina si lo ingresado es numerico
        if (isNaN(parseFloat(convertirMonedaACadena(obj.value))) || obj.value.length == 0) {
            alert('Por favor ingrese un valor valido.');
            obj.value = '';
            obj.focus;
        }
        else {
            //Se valida si la suma de los cupos hijos agregados es inferior o igaul al valor del cupo padre
            var valorCuposHijos = parseFloat(valoresCuposHijos());
            if (parseFloat(valorCuposHijos) > parseFloat(obj.value)) {
                alert("El valor del cupo credito no puede ser inferior al valor de los cupos hijos adiccionados.");
                obj.value = '';
                obj.focus;
            }
        }
    }
    catch (error) {
    }
}

//Este metodo funciona para las pantallas de creacion y modificacion de cupos creditos
//Metodo encargado de validar el valor ingresado al momento de crear un cupo hijo.
function validarValorCupoHijo(obj, objPadre) {
    try {
        var retorno = true;
        var objCupoPadre = objPadre;
        //Se valida si el valor del cupo hijo es numerico
        if (isNaN(parseFloat(convertirMonedaACadena(obj.value))) || obj.value == '') {
            alert('Por favor ingrese un valor valido.');
            obj.value = '';
            obj.focus;
            retorno = false;
        }
        else {
            //Se determina si el valor del cupo padre existe
            if (objCupoPadre.value != '') {
                //Se valida si el valor del cupo credito hijo es mayor al valor del cupo credito
                if (parseFloat(convertirMonedaACadena(obj.value)) > parseFloat(convertirMonedaACadena(objCupoPadre.value))) {
                    alert("El valor ingresado no puede ser superior al valor del cupo credito");
                    obj.value = '';
                    obj.focus;
                    retorno = false;
                }
                else {
                    //Se valida el valor de los cupos hijos + el valor a agregar es inferior al valor del cupo credito
                    var valorCuposHijos = parseFloat(valoresCuposHijos());
                    valorCuposHijos += parseFloat(convertirMonedaACadena(obj.value));
                    if (parseFloat(valorCuposHijos) > parseFloat(convertirMonedaACadena(objCupoPadre.value))) {
                        //alert("Valor cupo hijo:"+parseFloat(valorCuposHijos));
                        //alert("Valor cupo padre:"+parseFloat(objCupoPadre.value));
                        alert("No se puede agregar este cupo credito con este valor ya que la suma con los demas cupos creditos hijos sera superior al valor del cupo credito.");
                        retorno = false;
                    }
                }
            }
            else {
                alert("No se ha ingresado valor para el cupo credito");
                retorno = false;
            }
        }
    }
    catch (error) {
        alert(error);
        return retorno;
    }

    return retorno;
}

//Este metodo funciona para las pantallas de creacion y modificacion de cupos creditos
//Metodo encargado de sumar los valores de los cupos hijos
function valoresCuposHijos() {
    var valorCuposHijos = 0;
    //Se valida si existen cupos hijos ya agregados y si el valor de los cupos es superior al valor del cupo credito
    for (var a = 0;a < 5000;a++) {
        try {
            valorCuposHijos += parseFloat(convertirMonedaACadena(document.getElementById('form1:page1:table1:' + a + ':outputText2').innerHTML));
            //alert("Valor cupo hijo: "+valorCuposHijos);
        }
        catch (error) {
            break;
        }
    }
    return valorCuposHijos;
}

//Metodo encargado de realizar las validaciones en la pantalla de obligaciones.
function validarObligacion(error) {
    //Se determina si el tipo de obligacion es obligacion.
    var tipoObligacion = document.getElementById('form1:page1:selectOneChoice1');
    var moneda = document.getElementById('form1:page1:selectOneChoice2');
    var tipoPeriodicidadObligacion = document.getElementById('form1:page1:selectOneChoice4');
    var periodicidadObligacion = document.getElementById('form1:page1:selectOneChoice5');
    var periodicidadDiasObligacion = document.getElementById('form1:page1:inputText7');

    var mensaje = "Se presentaron los siguientes errores\n";
    var longitudInicialMensaje = mensaje.length;

    var control = true;

    //Si no se genero error se realizan las validaciones adicionales para la obligacion.
    if (error) {
        if (tipoObligacion.value == 0 || tipoObligacion.value == null) {
            mensaje += "- El tipo de obligacion es requerido.\n";
        }

        if (moneda.value == 0 || moneda.value == null) {
            mensaje += "- La moneda es requerida.\n";
        }

        if (tipoPeriodicidadObligacion.value == 0 || tipoPeriodicidadObligacion.value == null) {
            mensaje += "- El tipo de periodicidad de la obligacion es requerido.\n";
        }

        //Se valida el tipo de periodicidad seleccionado para la obligacion
        //Tipo de periodicidad de la obligacion periodo.
        if (tipoPeriodicidadObligacion.value == 1) {
            //Se valida si selecciono alguna periodicidad valida para la obligacion.
            if (periodicidadObligacion.value == 0 || periodicidadObligacion.value == null) {
                mensaje += "- Seleccione una periodicidad valida para la obligacion.\n";
            }
        }
        else {
            //Si el tipo de periodicidad de la obligacion es dias.
            if (tipoPeriodicidadObligacion.value == 2) {
                if (periodicidadDiasObligacion.value == 0 || periodicidadDiasObligacion.value.length == 0) {
                    mensaje += "- Ingrese la cantidad de dias aociados a la periodicidad de la oblgacion.\n";
                }
            }
        }

        //Validacion para la parte de los intereses, si el tipo de obligacion es obligacion.
        if (tipoObligacion.value == 1) {
            mensaje += validarInformacionIntereses();
        }

        //Se muestra el mensaje si hay necesidad.
        if (mensaje.length > longitudInicialMensaje) {
            alert(mensaje);
            control = false;
        }

        return control;
    }
}

//Funcion para la validacion del calculo de la tasa.
function validarCalculoTasa() {
    //Se realiza la validacion de los campo requeridos para calcular la tasa.
    var tasaNominal = document.getElementById('form1:page1:selectOneChoice6');
    var valorTasaFija = document.getElementById('form1:page1:inputText6');
    var tasaNominalVariable = document.getElementById('form1:page1:selectOneChoice7');
    var fechaDesembolso = document.getElementById('form1:page1:selectInputDate2');
    var tasaNominalEn = document.getElementById('form1:page1:selectOneChoice10');

    var mensaje = "Se presentaron los siguientes errores:\n";
    var longitudInicialMensaje = mensaje.length;

    if (tasaNominal.value == 0 || tasaNominal.value == null) {
        mensaje += "- La tasa nominal es requerida.\n"
    }

    //Tasa nominal fija.
    if (tasaNominal.value == 1) {
        //Se valida si ingreso el valor de la tasa fija.
        if (valorTasaFija == null || valorTasaFija.value.length == 0) {
            mensaje += "- Ingrese un valor para la tasa fija.\n";
        }
    }
    else {
        if (tasaNominal.value == 2) {
            //Se valida si selecciono la tasa variable.
            if (tasaNominalVariable == null || tasaNominalVariable.value == 0) {
                mensaje += "- Seleccione la tasa variable.\n";
            }
            else {
                //Se valida que la fecha desembolso se encuentre.
                if (fechaDesembolso.value == null || fechaDesembolso.value.length == 0) {
                    mensaje += "- La fecha desembolso es requerida.\n";
                }
            }
        }
    }

    //Se valida si selecciono la periodicidad de la tasa.
    if (tasaNominalEn.value == null || tasaNominalEn.value == 0) {
        mensaje += "- La periodicidad de la tasa es requerida.\n";
    }

    //Se muestra el mensaje si hay necesidad.
    if (mensaje.length > longitudInicialMensaje) {
        alert(mensaje);
        return false;
    }
    else {
        return true;
    }
}

//Metodo encargado de realizar la validacion para la parte de los intereses.
function validarInformacionIntereses() {
    var tipoPeriodicidadIntereses = document.getElementById('form1:page1:selectOneChoice9');
    var periodicidadInteresesPeriodo = document.getElementById('form1:page1:selectOneChoice8');
    var periodicidadInteresesDias = document.getElementById('form1:page1:inputText11');
    var tasaEfectiva = document.getElementById('form1:page1:inputText10');

    var mensaje = "";

    //Se valida que exista un valor en la tasa calculada.
    if (tasaEfectiva.value.length == 0) {
        mensaje += "- La tasa efectiva es requerida.\n";
    }

    //Se valida si selecciono la periodicidad de los intereses.
    if (tipoPeriodicidadIntereses.value == 0 || tipoPeriodicidadIntereses.value == null) {
        mensaje += "- El tipo de periodicidad de los intereses es requerida.\n";
    }
    else {
        //Si selecciono la periodicida de los intereses, se determina si es periodo o dias y si selecciono o ingreso el valor de la periodicidad.
        //Tipo de periodicidad periodo.
        if (tipoPeriodicidadIntereses.value == 1) {
            //Se valida si selecciono la periodicidad de los intereses.
            if (periodicidadInteresesPeriodo.value == null || periodicidadInteresesPeriodo.value == 0) {
                mensaje += "- La periodicidad de los interese es requerida.\n";
            }
        }
        else {
            //Tipo de periodicidad dias.
            if (tipoPeriodicidadIntereses.value == 2) {
                //Se valida si ingreso la cantidad de dias.
                if (periodicidadInteresesDias.value == null || periodicidadInteresesDias.value.length == 0) {
                    mensaje += "- Ingrese la cantidad de dias asociados a la periodicidad de los intereses.\n";
                }
            }
        }
    }
    return mensaje;
}

function validarDouble(obj, valor, enteros, decimales) {
    //intento convertir a entero. 
    //si era un entero no le afecta, si no lo era lo intenta convertir 
    valor = stripNonNumeric(valor);
    //valor = parseFloat(valor);
    //Compruebo si es un valor num�rico 
    if (isNaN(valor)) {
        //entonces (no es numero) devuelvo el valor cadena vacia 
        obj.value = "";
    }
    else {
        //En caso contrario (Si era un n�mero) devuelvo el valor 
        obj.value = valor;
    }
}

function validarEntero(obj, valor) {
    //intento convertir a entero. 
    //si era un entero no le afecta, si no lo era lo intenta convertir 
    valor = parseInt(valor);

    //Compruebo si es un valor num�rico 
    if (isNaN(valor)) {
        //entonces (no es numero) devuelvo el valor cadena vacia 
        obj.value = "";
    }
    else {
        //En caso contrario (Si era un n�mero) devuelvo el valor 
        obj.value = valor;
    }
}

// This function removes non-numeric characters
function stripNonNumeric(obj) {
    str =obj.value+'';
    //var rgx = /^\d|\.|-$/;
    var rgx = /^\d|\,|-$/;
    var out = '';
    for (var i = 0;i < str.length;i++) {
        if (rgx.test(str.charAt(i))) {
            if (!((str.charAt(i) == '.' && out.indexOf('.') !=  - 1) || (str.charAt(i) == '-' && out.length != 0))) {
                out += str.charAt(i);
            }
        }
    }
    obj.value = out;
    return out;
}

function numberFormat(nStr, obj, dec) {
    nStr += '';
    //x = nStr.split('.');
    x = nStr.split(',');

    x1 = x[0];
    //x2 = x.length > 1 ? '.' + x[1] : '';
    x2 = x.length > 1 ? ',' + x[1] : '';

    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + '.' + '$2');

    }

    if (dec)
        str = x1 + x2;
    else 
        str = x1;

    obj.value = str

}

/*
Metodo: Permite Bloquera el acceso de carateres diferentes a [0-9] y borrado
Autor: Luis Alberto Bola�os
*/
function validarNumber(obj, e, space) {

    var code;
    if (!e)
        var tecla = window.event;

    if (e.keyCode)
        tecla = e.keyCode;
    else if (e.which)
        tecla = e.which;

    if (tecla == 8 || tecla == 35 || tecla == 36 || tecla == 37 || tecla == 39)
        return true;//Tecla de retroceso (para poder borrar) 
    patron = /[0-9]/;//ver nota 
    te = String.fromCharCode(tecla);

    if (!patron.test(te)) {
        str = obj.value;
        str = str.replace(/[A-Z]/gi, "");

        if (!space)
            str = str.replace(/\W/gi, "");
        else 
            str = str.replace(/\W/gi, "");

        obj.value = str;
    }

}

function validarAlpha(obj, e) {

    var code;
    if (!e)
        var tecla = window.event;

    if (e.keyCode)
        tecla = e.keyCode;
    else if (e.which)
        tecla = e.which;

    if (tecla == 8 || tecla == 35 || tecla == 36 || tecla == 37 || tecla == 39)
        return true;//Tecla de retroceso (para poder borrar) 
    patron = /[A-Z]/;//ver nota 
    te = String.fromCharCode(tecla);

    if (!patron.test(te)) {
        str = obj.value;
        str = str.replace(/[0-9]/gi, "");

        obj.value = str;
    }

}

function validarNumberAndWhiteSpace(obj, e) {

    var code;
    if (!e)
        var tecla = window.event;

    if (e.keyCode)
        tecla = e.keyCode;
    else if (e.which)
        tecla = e.which;

    if (tecla == 8 || tecla == 35 || tecla == 36 || tecla == 37 || tecla == 39)
        return true;//Tecla de retroceso (para poder borrar) 
    patron = /[0-9]/;//ver nota 
    te = String.fromCharCode(tecla);

    if (!patron.test(te)) {
        str = obj.value;
        str = str.replace(/[A-Z]/gi, "");
        str = str.replace(/\Wgi/, "");
        obj.value = str;
    }

}

//Realizado Por luis alberto Bola�os
//Establece el foco de Campos puede enviarse id, o el objecto (this)
function setFocus(obj) {

    if (typeof (obj) == "string")
        document.getElementById('form1:page1:' + obj).focus();
    else if (typeof (obj) == "object")
        obj.setFocus();
}

//Valida Cada digito  de las fechas para verificar que sean numeros
//Realizado Por luis alberto Bola�os
function IsNumeric(valor) {
    var log = valor.length;
    var sw = "S";

    for (x = 0;x < log;x++) {
        v1 = valor.substr(x, 1);
        v2 = parseInt(v1);

        //Compruebo si es un valor num�rico 
        if (isNaN(v2)) {
            sw = "N";
        }
    }

    if (sw == "S") {
        return true;
    }
    else {
        return false;
    }
}

// #Crea una mascara de fechas tipo Access
//Realizado Por luis alberto Bola�os
var primerslap = false;
var segundoslap = false;

function formateafecha(obj) {
    var fecha = obj.value;
    var long = fecha.length;
    var dia;
    var mes;
    var ano;

    //Validacion de Mes:
    if ((long >= 2) && (primerslap == false)) {
        mes = fecha.substr(0, 2);

        if ((IsNumeric(mes) == true) && (mes <= 12) && (mes != "00")) {
            fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
            primerslap = true;
        }
        else {
            fecha = "";
            primerslap = false;
        }
    }
    else {
        mes = fecha.substr(0, 1);

        if (IsNumeric(mes) == false) {
            fecha = "";
        }

        if ((long <= 2) && (primerslap = true)) {
            fecha = fecha.substr(0, 1);
            primerslap = false;
        }
    }

    //Valida Dia:
    if ((long >= 5) && (segundoslap == false)) {
        mes = fecha.substr(0, 2);
        dia = fecha.substr(3, 2);
        diasMes = 0;
        num = parseInt(mes);

        //Validacion de Dias por mes sin tomar en cuenta a�o
        if (num == 2) {
            diasMes = 29;
        }
        else {

            if (num % 2 == 0 && num < 8)
                diasMes = 30;

            if (num % 2 == 0 && num >= 8)
                diasMes = 31;

            if (num % 2 != 0 && num < 8)
                diasMes = 31;

            if (num % 2 != 0 && num >= 8)
                diasMes = 30;
        }

        if ((IsNumeric(dia) == true) && (dia <= diasMes) && (dia != "00")) {
            fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
            segundoslap = true;
        }
        else {
            fecha = fecha.substr(0, 3);
            segundoslap = false;
        }
    }
    else {
        if ((long <= 5) && (segundoslap = true)) {
            fecha = fecha.substr(0, 4);
            segundoslap = false;
        }
    }

    //Validar A�o
    if (long >= 7) {
        anho = fecha.substr(6, 4);
        if (IsNumeric(anho) == false) {
            fecha = fecha.substr(0, 6);
        }
        else {
            if (long == 10) {
                if ((anho == 0) || (anho < 1000) || (anho > 9999)) {
                    fecha = fecha.substr(0, 6);
                }
            }
        }
    }

    //Validacionn de Dias
    if (long >= 10) {
        fecha = fecha.substr(0, 10);
        mes = fecha.substr(0, 2);
        dia = fecha.substr(3, 2);
        anho = fecha.substr(6, 4);

        //Validacion Bisiesto
        if ((anho % 4 != 0) && (mes == 02) && (dia > 28)) {
            fecha = fecha.substr(0, 2) + "/";
        }

    }

    obj.value = fecha;
    //return (fecha); 
}

function formateafechaForm1(obj) {
    var fecha = obj.value;
    var format = "";
    var long = fecha.length;
    var dia;
    var mes;
    var ano;

    with (event) {

        /*
       if(keyCode==17 && keyCode==16 && keyCode==188){
        alert('dfsdaf');
        obj.value= new Date();
        return false;
       }
      */
        if (ctrlKey && shiftKey && keyCode == 188) {
            fecha = new Date();

            if (fecha.getDate() < 10)
                format = "0" + fecha.getDate();
            else 
                format = fecha.getDate();

            if ((fecha.getMonth() + 1) < 10)
                format += "/0" + (fecha.getMonth() + 1);
            else 
                format += "/" + (fecha.getMonth() + 1);

            if (fecha.getFullYear() < 10)
                format += "/0" + (fecha.getFullYear());
            else 
                format += "/" + fecha.getFullYear();

            obj.value = format;

            //obj.value= fecha.getDate() + "/" + (fecha.getMonth()+1) + "/" + fecha.getFullYear();
            return false;
        }

        if (keyCode == 35 || keyCode == 36 || keyCode == 37 || keyCode == 38 || keyCode == 39 || keyCode == 40 || keyCode == 8)
            return false;

    }

    if ((long >= 2) && (primerslap == false)) {
        dia = fecha.substr(0, 2);

        if ((IsNumeric(dia) == true) && (dia <= 31) && (dia != "00")) {
            fecha = fecha.substr(0, 2) + "/" + fecha.substr(3, 7);
            primerslap = true;
        }
        else {
            fecha = "";
            primerslap = false;
        }
    }
    else {
        dia = fecha.substr(0, 1);

        if (IsNumeric(dia) == false) {
            fecha = "";
        }

        if ((long <= 2) && (primerslap = true)) {
            fecha = fecha.substr(0, 1);
            primerslap = false;
        }
    }

    if ((long >= 5) && (segundoslap == false)) {
        //mes = fecha.substr(3,2); 
        mes = fecha.substr(3, fecha.length);

        dia = fecha.substr(0, 2);
        diasMes = 0;

        //num = parseInt(mes);
        num = 0;

        if (mes.charAt(0) == "0")
            num = parseInt(mes.charAt(1));
        else 
            num = parseInt(mes);

        //Validacion de Dias por mes sin tomar en cuenta a�o
        if (num == 2) {
            diasMes = 29;
        }
        else {

            if (num % 2 == 0 && num < 8)
                diasMes = 30;

            if (num % 2 == 0 && num >= 8)
                diasMes = 31;

            if (num % 2 != 0 && num < 8)
                diasMes = 31;

            if (num % 2 != 0 && num >= 8)
                diasMes = 30;
        }

        if ((IsNumeric(mes) == true) && (mes <= 12) && (mes != "00") && (dia <= diasMes)) {
            fecha = fecha.substr(0, 5) + "/" + fecha.substr(6, 4);
            segundoslap = true;
        }
        else {
            fecha = fecha.substr(0, 3);
            segundoslap = false;
        }
    }
    else {
        if ((long <= 5) && (segundoslap = true)) {
            fecha = fecha.substr(0, 4);
            segundoslap = false;
        }
    }

    if (long >= 7) {
        ano = fecha.substr(6, 4);
        if (IsNumeric(ano) == false) {
            fecha = fecha.substr(0, 6);
        }
        else {
            if (long == 10) {
                if ((ano == 0) || (ano < 1900) || (ano > 2100)) {
                    fecha = fecha.substr(0, 6);
                }

            }
        }
    }

    if (long >= 10) {
        fecha = fecha.substr(0, 10);
        dia = fecha.substr(0, 2);
        mes = fecha.substr(3, 2);
        ano = fecha.substr(6, 4);

        // A�o no viciesto y es febrero y el dia es mayor a 28 
        if ((ano % 4 != 0) && (mes == 02) && (dia > 28)) {
            fecha = fecha.substr(0, 2) + "/";
        }
    }

    if (!primerslap)
        obj.value = fecha;
    else if (!primerslap && !segundoslap)
        obj.value = fecha;

    else if (long < 10) {

        if (long != 3 && long != 6 && long != 10) {
            obj.value = fecha;
        }

    }

}

/* validaciones de Horas  */

function formateaHoraForm1(fecha) {

    var long = fecha.length;
    var hora;
    var min;
    var seg;

    if ((long >= 2) && (primerslap == false)) {
        hora = fecha.substr(0, 2);

        if ((IsNumeric(hora) == true) && (hora <= 12) && (hora != "00")) {
            fecha = fecha.substr(0, 2) + ":" + fecha.substr(3, 7);
            primerslap = true;
        }
        else {
            fecha = "";
            primerslap = false;
        }
    }
    else {
        hora = fecha.substr(0, 1);

        if (IsNumeric(hora) == false) {
            fecha = "";
        }

        if ((long <= 2) && (primerslap = true)) {
            fecha = fecha.substr(0, 1);
            primerslap = false;
        }
    }

    if ((long >= 5) && (segundoslap == false)) {
        min = fecha.substr(3, 2);

        if ((IsNumeric(min) == true) && (min <= 59) && (min >  - 1)) {
            fecha = fecha.substr(0, 5) + ":" + fecha.substr(6, 4);
            segundoslap = true;
        }
        else {
            fecha = fecha.substr(0, 3);
            segundoslap = false;
        }
    }
    else {
        if ((long <= 5) && (segundoslap = true)) {
            fecha = fecha.substr(0, 4);
            segundoslap = false;
        }
    }

    if (long >= 7) {
        seg = fecha.substr(6, 2);

        if (IsNumeric(seg) == false || seg > 59 || seg <=  - 1) {
            fecha = fecha.substr(0, 6);

        }

    }

    return (fecha);
}

function formateaHoraForm2(fecha) {

    var long = fecha.length;
    var hora;
    var min;
    var seg;

    if ((long >= 2) && (primerslap == false)) {
        hora = fecha.substr(0, 2);

        if ((IsNumeric(hora) == true) && (hora <= 12) && (hora != "00")) {
            fecha = fecha.substr(0, 2) + ":" + fecha.substr(3, 7);
            primerslap = true;
        }
        else {
            fecha = "";
            primerslap = false;
        }
    }
    else {
        hora = fecha.substr(0, 1);

        if (IsNumeric(hora) == false) {
            fecha = "";
        }

        if ((long <= 2) && (primerslap = true)) {
            fecha = fecha.substr(0, 1);
            primerslap = false;
        }
    }

    if ((long >= 5) && (segundoslap == false)) {
        min = fecha.substr(3, 2);

        if ((IsNumeric(min) == true) && (min <= 59) && (min >  - 1)) {
            fecha = fecha.substr(0, 5) + "" + fecha.substr(6, 4);
            segundoslap = true;
        }
        else {
            fecha = fecha.substr(0, 3);
            segundoslap = false;
        }
    }
    else {
        if ((long <= 5) && (segundoslap = true)) {
            fecha = fecha.substr(0, 4);
            segundoslap = false;
        }
    }

    return (fecha);
}

function bloquearPantalla() {
    alert("sads");

    document.getElementById("bloqueador").style.position = "absolute";
    document.getElementById("bloqueador").style.top = "0px";
    document.getElementById("bloqueador").style.left = "0px";
    //document.getElementById("bloqueador").style.background = "url(../../images/transp.png) repeat";     
    document.getElementById("bloqueador").style.background = "#CCCCCC";
    document.getElementById("bloqueador").style.width = "100%";
    document.getElementById("bloqueador").style.height = "100%";
    document.getElementById("bloqueador").style.zIndex = "1000000";

    alert(document.getElementById("bloqueador").style.background);

}

function desBloquearPantalla() {
    alert(document.getElementById("bloqueador"));
    document.getElementById("bloqueador").className = 'enabler';
}

function syncronizedBloqueo() {
    alert("gggggggg");
    timer = setInterval("bloquearPantalla()", 5000);

}

function BloqueoAlphaNum(e) {

    var e = window.event || e
    var keyunicode = e.charCode || e.keyCode
    //Allow alphabetical keys, plus BACKSPACE and SPACE
    return (keyunicode >= 65 && keyunicode <= 122 || keyunicode == 8 || keyunicode == 32) ? true : false

}

/*
    funcion: Establece el foco para los controles 
    Parametros:
    id : la propiedad id de componente
    Autor: Luis Alberto Bola�os
    Email: labs.sistemas@gmail.com
*/
function setFocus(id) {
    document.getElementById(id).focus();

}

/*
    funcion: Bloquea el acceso de alpha en campos input
    Parametros:
    evt : evento
    Autor: Luis Alberto Bola�os
    Email: labs.sistemas@gmail.com
*/
function onlyNumbers(obj) {
    document.getElementById(obj.id).onkeypress = function (e) {
        var e = window.event || e

        var keyunicode = e.charCode || e.keyCode

        // 48 - 57
        //Allow alphabetical keys, plus BACKSPACE and SPACE
        if (keyunicode >= 48 && keyunicode <= 57) {
            return true;
        }
        else {
            return false;
        }
    }

    //return (keyunicode>=65 && keyunicode<=122 || keyunicode==8 || keyunicode==32)? true : false
}

function keyDownAction(obj) {

    with (event) {

        if (keyCode == 13 || keyCode == 9) {
            document.getElementById('form1:page1:objectImage1').click()
        }
    }
}

function ingresoDirecciones(objeto) {
    // Se establece el id del componente en el campo oculto.
    var campoOculto = document.getElementById("inputHidden1");
    campoOculto.value = objeto.id;

    // Se ejecuta el onclick del boton encargado de mostrar la pantalla.
    document.getElementById("commandButton1").click();
}

/**
 * Funcion que permite solo el ingreso de letras y espacio en blanco.
 * @param evento
 */
function validarLetrasEspacio(evento) {
    tecla = (document.all) ? evento.keyCode : evento.which;
    if (tecla == 8)
        return true;
    patron = /[A-Za-z\s]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

/**
 * Funcion encargada de asignar el numero de cedula digitado en la pantalla dinamica a un campo oculto para poder realizar la consulta de los datos del girador.
 */
function asignarCedula(cedula) {
    document.getElementById("inputHidden2").value = cedula;

    // Se ejecuta el onclick del boton encargado de realizar la consulta.
    document.getElementById("commandButton2").click();
}

function isNumberKey(evt) {
    var key = window.event ? event.keyCode : event.which;
    if ((key >= 96 && key <= 105) || key == 8)
        return true;

    return false;
}

function validarFormularioSolicitudes() {
    // Se obtiene los id's de los campos marcados como requeridos.
    ids = document.getElementById("camposRequeridos").value;
    ids = ids.substring(0, ids.length - 1);
    camposRequeridos = ids.split(":");
    var idCampo;
    var tipoComponente;
    var pasa;
    var enviarPeticion = true;

    if (camposRequeridos.length > 0) {
        for (i = 0;i < camposRequeridos.length;++i) {
            idCampo = camposRequeridos[i].split("-")[0];
            tipoComponente = camposRequeridos[i].split("-")[1];

            // Se determina el tipo de componente.
            if (tipoComponente == 2 || tipoComponente == 3 || tipoComponente == 12 || tipoComponente == 13) {
                pasa = validarInputText(idCampo);
                ocultarMostrarAlerta(idCampo, pasa);
                if (!pasa)
                    enviarPeticion = false;
            }
            else {
                if (tipoComponente == 4) {
                    pasa = validarInputText(idCampo);
                    ocultarMostrarAlerta(idCampo, pasa);
                    if (!pasa)
                        enviarPeticion = false;
                }
                else {
                    if (tipoComponente == 5 || tipoComponente == 6) {
                        pasa = validarRadioCheck(idCampo);
                        ocultarMostrarAlerta(idCampo, pasa);
                        if (!pasa)
                            enviarPeticion = false;
                    }
                }
            }
        }
    }

    if (!enviarPeticion) {
        // Se muestra el componente de mensaje.
        $(document).ready(function () {
            mostrarMensaje('Hay campos requeridos sin valor', 'ALERTA', 'alerta.png');
        });
    }

    return enviarPeticion;
}

function ocultarMostrarAlerta(idCampo, pasa) {
    if (pasa) {
        $("#" + idCampo + "TextoRequerido").css("display", "none");
        $("#" + idCampo + "TextoRequerido").css("visibility", "hidden");
    }
    else {
        $("#" + idCampo + "TextoRequerido").css("display", "block");
        $("#" + idCampo + "TextoRequerido").css("visibility", "visible");
        enviarPeticion = false;
    }
}

function validarInputText(id) {
    if ($.trim($("#" + id).val()) == '') {
        return false;
    }
    else {
        return true;
    }
}

function validarSelect(id) {
    if ($.trim($("#" + id).val()) == '') {
        return false;
    }
    else {
        return true;
    }
}

function validarRadioCheck(id) {
    if ($("[name='" + id + "']").is(':checked')) {
        return true;
    }
    else {
        return false;
    }
}

/**
 * Metodo encargado de validar si una direccion de e-mail es valida
 * @param email
 */
function IsEmail(email) {
    var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email);
}

/**
 * Metodo encargado de eliminar espacios en blanco a la izquierda y derecha de una cadena.
 * @param myString
 */
function trim(myString) {
    return myString.replace(/^\s+/g, '').replace(/\s+$/g, '')
}

function validarEmail(email, id, idBotonCrear, idBotonGuardarParcial, idBotonModificar) {

    var estadoInicialBotonCrear=false;
    var estadoInicialBotonGuardarParcial=false;
    var estadoInicialBotonModificar=false;

    var cadena = trim(email);
    var object = document.getElementById(id);
    var row = document.createElement("tr");
    var cell = document.createElement("td");
    cell.setAttribute("id", "celdaErrorEmail" + id);
    cell.setAttribute("class", "textoRequerido");
    var cell2 = document.createElement("td");
    var span = document.createElement("span");
    span.setAttribute("style", "font-family:Arial,Helvetica,Geneva,sans-serif;font-size:8pt;font-weight:normal;color:#cc0000");
    var text = document.createTextNode("Email invalido");

    if (cadena != null && cadena != "" && cadena.length > 0) {
        valido = IsEmail(email);
        if (valido) {
            if (document.getElementById("celdaErrorEmail" + id) != null) {
                document.getElementById("celdaErrorEmail" + id).parentNode.removeChild(document.getElementById("celdaErrorEmail" + id));
            }
            document.getElementById(idBotonBloquear).disabled = false;
            return true;
        }
        else {
            if (object != null && document.getElementById("celdaErrorEmail" + id) == null) {
                // Se adicionan los elementos.
                span.appendChild(text);
                cell.appendChild(span);
                row.appendChild(cell2);
                row.appendChild(cell);
                object.parentNode.parentNode.parentNode.appendChild(row);
            }
        }
    }
    else {
        if (document.getElementById("celdaErrorEmail" + id) != null) {
            document.getElementById("celdaErrorEmail" + id).parentNode.removeChild(document.getElementById("celdaErrorEmail" + id));
        }
        document.getElementById(idBotonCrear).disabled = false;
        return true;
    }

    document.getElementById(idBotonCrear).disabled = true;
    return false;
}