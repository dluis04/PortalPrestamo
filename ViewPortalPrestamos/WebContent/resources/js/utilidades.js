// Funcion para obtener el nombre del contexto.
function getContext() {
    var path = location.pathname;
    var context = "";
    var posfin;
    for (var i = 1;i < path.length;i++)
        if (path.charAt(i) == '/') {
            context = path.substring(1, i);
            return context;
        }
}

//recibe el nombre del comando a ejecutar para cancelar la operacion
function cancelarOperacion(cmd, nombreComando) {
    if (document.getElementById(cmd) != null)
        document.getElementById(cmd).value = nombreComando
    else {
        obj = document.getElementsByName(cmd)
        obj[0].value = nombreComando;
    }
    document.forms[0].submit();
}

//llama a un comando con Remote scripting para que deshaga la operacion
function cancelarOperacionRs(ruta, cmd, nombreComando) {
    matriz = createArray(1, 2);
    matriz[0][0] = cmd;
    matriz[0][1] = nombreComando;
    jsrsExecute(ruta, populateForm, "perfomTask", matriz);

}

function inhabilitarText(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0));

    if (charCode == 9) {
        return true;
    }
    else {
        charCode = 0;
        return false;
    }
}

/*funcion que detecta si se presiono enter*/
function detectarEnter(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0));
    if (charCode == 13) {
        return true;
    }
    else {
        return false;
    }
}

/*funcion que detecta si se presiono tab*/
function detectarTab(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0));
    if (charCode == 9) {
        return true;
    }
    else {
        return false;
    }
}

//oculta un frame, recibe el objeto frame
var size = 0;
var marco;
var total;

function ocultarFrameVerticalIzquierdo(frame, tamano) {
    if (frame.cols != '0,*')//si se esta mostrando el frame
    {
        size = tamano;
        marco = frame;
        disminuirTamanoFrame()
    }
}

//muestra un frame, recibe el objeto frame y el tamaño al cual debe expandirse
function verFrameVerticalIzquierdo(frame, tamano) {
    //if (frame.cols=='0,*')//si esta oculto
    //{
    total = tamano;
    marco = frame;
    aumentarTamanoFrame();
    //} 
}

function wait(funcion, delay) {
    string = funcion;
    setTimeout(string, delay);
}

function disminuirTamanoFrame() {
    size = size - 10;
    marco.cols = '' + size + ',*';
    if (size > 0) {
        Id = wait("disminuirTamanoFrame()", 10);
    }
}

function aumentarTamanoFrame() {
    size = size + 10;
    marco.cols = '' + size + ',*';
    if (size <= total) {
        Id = wait("aumentarTamanoFrame()", 10);
    }
    else 
        marco.cols = '' + total + ',*';

}

function abrirVentanaModal(direccion, titulo) {
    //open pop up window passing account ref to pop up page
    var alto = 700;
    var ancho = 900;
    var izquierda = Math.ceil(screen.width / 2 - (ancho / 2));
    var arriba = Math.ceil(screen.height / 2 - (alto / 2) - 50);
    options = "width=" + ancho + ", height=" + alto + ", location=no, menubar=no, status=yes, toolbar=no, scrollbars=yes, resizable=yes,top=" + arriba + ",left=" + izquierda;
    title = titulo;
    url = direccion;
    modalWindow = window.open(url, title, options);
    modalWindow.focus()
}

/*Desahabilita o habilita un campo de la forma*/
// nombrecampo,true/false
function enableForm() {
    clearFormSpace();
    var i, nm, args = enableForm.arguments;
    for (i = 0;i < (args.length - 1);i += 2) {
        val = BuscarObjeto(args[i]);
        if (val) {
            nm = args[i + 1];
            if (nm == 'true')
                val.disabled = false;
            else {
                val.disabled = true;
                val.value = '';
            }
        }
    }
}

function limpiarClipBoard() {
    var meintext = "";

    if (document.all) {
        try {
            // the IE-manier
            window.clipboardData.clearData();
            window.clipboardData.setData("Text", meintext);
        }
        catch (e) {
        }
        // waarschijnlijk niet de beste manier om Moz/NS te detecteren;
        // het is mij echter onbekend vanaf welke versie dit precies werkt:
    }
    else if (window.netscape) {
        // dit is belangrijk maar staat nergens duidelijk vermeld:
        // you have to sign the code to enable this, or see notes below 
        netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');

        // maak een interface naar het clipboard
        var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
        if (!clip)
            return;

        // maak een transferable
        var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
        if (!trans)
            return;

        // specificeer wat voor soort data we op willen halen; text in dit geval
        trans.addDataFlavor('text/unicode');

        // om de data uit de transferable te halen hebben we 2 nieuwe objecten nodig   om het in op te slaan
        var str = new Object();
        var len = new Object();

        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
        var copytext = meintext;
        str.data = copytext;
        trans.setTransferData("text/unicode", str, copytext.length * 2);
        var clipid = Components.interfaces.nsIClipboard;
        if (!clip)
            return false;
        clip.setData(trans, null, clipid.kGlobalClipboard);

    }
    //alert("Following info was copied to your clipboard:\n\n" + meintext);
    return false;
}

function obtenerAnoActual() {
    var now = new Date();
    var year = now.getYear();
    if (year < 2000)
        year = year + 1900;// mozilla
    return year;
}

function obtenerMesActual() {
    var now = new Date();
    var month = now.getMonth() + 1;
    if (month < 10)
        return '0' + month;
    else 
        return month;
}

function obtenerDiaActual() {
    var now = new Date();
    var date = now.getDate();
    if (date < 10)
        return '0' + date;
    else 
        return date;
}

function obtenerHoraActual() {
    var now = new Date();
    var hh = now.getHours();
    if (hh < 10)
        return '0' + hh;
    else 
        return hh;
}

function obtenerMinutosActual() {
    var now = new Date();
    var mm = now.getMinutes();
    if (mm < 10)
        return '0' + mm;
    else 
        return mm;
}

function obtenerSegundosActual() {
    var now = new Date();
    var ss = now.getSeconds();
    if (ss < 10)
        return '0' + ss;
    else 
        return ss;
}

function obtenerSegundosActual() {
    var now = new Date();
    var ss = now.getSeconds();
    if (ss < 10)
        return '0' + ss;
    else 
        return ss;
}

function obtenerFechaHoraActual() {
    var now = new Date();
    var year = now.getYear();
    var month = now.getMonth() + 1;
    var date, hh, mm, ss;
    if (year < 2000)
        year = year + 1900;// mozilla
    if (month < 10)
        month = '0' + month;
    date = now.getDate();
    if (date < 10)
        date = '0' + date;
    hh = now.getHours();
    if (hh < 10)
        hh = '0' + hh;
    mm = now.getMinutes();
    if (mm < 10)
        mm = '0' + mm;
    ss = now.getSeconds();
    if (ss < 10)
        ss = '0' + ss;
    return year + "-" + month + "-" + date + " " + hh + ":" + mm + ":" + ss;
}

function irA(url) {
    //manda la pagina a la direccion determinada por el comnado
    window.location = url;
}

//Convierte el valor de un campo en formato moneda
// Original:  Cyanide_7 (leo7278@hotmail.com) 
// Web Site:  http://www7.ewebcity.com/cyanide7 
function formatCurrency(num) {
    if (num != null && num != '') {
        num = num.toString().replace(/\$|\,/g, '');
        if (isNaN(num))//si no es un numero retorna null
            return 0;
        sign = (num == (num = Math.abs(num)));
        num = Math.floor(num * 100 + 0.50000000001);
        cents = num % 100;
        num = Math.floor(num / 100).toString();
        if (cents < 10)
            cents = "0" + cents;
        for (var i = 0;i < Math.floor((num.length - (1 + i)) / 3);i++)
            num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
        return (((sign) ? '' : '-') + '' + num + '.' + cents);//se quito el simbolo de pesos $
    }
    else 
        return 0;
}

//Funcion que suma dos cadenas de texto en formato moneda
function sumarMoneda(valor1, valor2) {

    var num1 = "";
    var num2 = "";
    var caracter = "";
    //quita las comas del valor ppor ejemplo 142,980.99 lo transforma en 142980.99
    for (var i = 0;i < valor1.length;i++) {
        if (i + 1 == valor1.length)
            caracter = valor1.substring(i);
        else 
            caracter = valor1.substring(i, i + 1);
        if (caracter != ",")
            num1 += caracter;
    }
    for (var j = 0;j < valor2.length;j++) {
        if (j + 1 == valor2.length)
            caracter = valor2.substring(j);
        else 
            caracter = valor2.substring(j, j + 1);
        if (caracter != ",")
            num2 += caracter;
    }
    var total = parseFloat(num1) + parseFloat(num2);
    return formatCurrency(total);//retorna el valor en formato moneda
}

function convertirMonedaACadena(valor1) {

    var num1 = "";
    var caracter = "";
    //quita las comas del valor ppor ejemplo 142,980.99 lo transforma en 142980.99
    for (var i = 0;i < valor1.length;i++) {
        if (i + 1 == valor1.length)
            caracter = valor1.substring(i);
        else 
            caracter = valor1.substring(i, i + 1);
        if (caracter != ",")
            num1 += caracter;
    }
    return num1.toString();

}

/*
  Desarrollador por: Jhon Robert Quintero H. - J&V Software Ltda.
  Funcion en JavaScript que permite pasar al siguiente formulario.
*/
function llamarSiguienteFormulario(cmd, dir, idLabel, idBloque, label, bloque, comandoCargar) {

    var matriz = createArray(5, 2)
    var params;
    var vector;

    matriz[0][0] = "comandoEjecutar";
    matriz[0][1] = comandoCargar;
    matriz[1][0] = idLabel;
    matriz[1][1] = label;
    matriz[2][0] = idBloque;
    matriz[2][1] = bloque;
    matriz[3][0] = cmd;
    matriz[3][1] = "cmdLlamarSiguienteFormulario";

    jsrsExecute(dir, resultadoBotonSiguienteFormulario, "perfomTask", matriz);

}

function resultadoBotonSiguienteFormulario(resultado) {
    if (resultado.indexOf("ERROR", 0) != 0) {
        var datos = resultado.split('|')

        /*verificar si no hay mas formularios*/
        resultadoPagina = datos[1].split('°')
        if (resultadoPagina[0] == 'noHaySiguiente') {
            // imprimir mensaje informando que no hay mas formularios
            alert(resultadoPagina[2]);
        }
        // invocar siguiente formulario
        parent.location = resultadoPagina[1]
    }
    else {
        alert(resultado);
    }
}

/***********************************Funciones para mostrar una barra de progreso*************************************/

var progressEnd = 9;// set to number of progress <span>'s.
var progressColor = 'blue';// set to progress bar color
var progressInterval = 1000;// set to time between updates (milli-seconds)
var progressAt = progressEnd;
var progressTimer;

function progress_clear() {
    for (var i = 1;i <= progressEnd;i++)
        document.getElementById('progress' + i).style.backgroundColor = 'transparent';
    progressAt = 0;
}

function progress_update() {
    progressAt++;
    if (progressAt > progressEnd)
        progress_clear();
    else 
        document.getElementById('progress' + progressAt).style.backgroundColor = progressColor;
    progressTimer = setTimeout('progress_update()', progressInterval);
}

function progress_stop() {
    clearTimeout(progressTimer);
    progress_clear();
}

function startProgressBar(seconds) {
    if (document.all) {
        // Internet Explorer
        progress.className = 'show';
        progress.style.left = (document.body.clientWidth) - (progress.offsetWidth);
        progress.style.top = ((document.body.clientHeight) - (progress.offsetHeight)) / 2;
    }
    else if (document.layers) {
        // Netscape
        document.progress.visibility = true;
        document.progress.left = (window.innerWidth) - 100;
        document.progress.top = (window.innerHeight) - 40;
    }

    progress_update();// start progress bar
}

function stopProgressBar() {
    if (document.all) {
        // Internet Explorer
        progress.className = 'hide';
    }
    else if (document.layers) {
        // Netscape
        document.progress.visibility = false;
    }
    progress_stop();//stop progress bar
}

function bar() {
    document.write("<table id=\"progress\" class= 'hide' align=\"center\"><tr><td>");
    document.write("<div style=\"font-size:8pt;padding:2px;border:solid black 1px;z-index: 20000;\">");
    document.write("<span id=\"progress1\">&nbsp; &nbsp;   </span>");
    document.write("<span id=\"progress2\">&nbsp; &nbsp;   </span>");
    document.write("<span id=\"progress3\">&nbsp; &nbsp;   </span>");
    document.write("<span id=\"progress4\">&nbsp; &nbsp;   </span>");
    document.write("<span id=\"progress5\">&nbsp; &nbsp;   </span>");
    document.write("<span id=\"progress6\">&nbsp; &nbsp;   </span>");
    document.write("<span id=\"progress7\">&nbsp; &nbsp;   </span>");
    document.write("<span id=\"progress8\">&nbsp; &nbsp;   </span>");
    document.write("<span id=\"progress9\">&nbsp; &nbsp;   </span>");
    document.write("</div> </td></tr></table>");
}

function ingresarTabla(result, idTabla) {
    var filas = new Array();
    var columnas = new Array();
    eliminarTodasLasFilas(idTabla);
    if (result.indexOf("ERROR") !=  - 1) {
        arreglo = result.split('|');
        alert(arreglo[1]);
    }
    else if (result != '') {
        var tr, td;
        filas = result.split("º");
        for (i = 0;i < filas.length;i++) {
            tr = crearTR(idTabla, 'SnowAltDataTD');
            columnas = filas[i].split("|");
            for (j = 0;j < columnas.length;j++) {
                td = crearTD(tr);
                td.innerHTML = columnas[j];
            }
        }
    }
    //fin else  
}

function informacion(texto) {
    if (document.all)//si es IE
    {
        makeMsgBox(texto);
    }
    else //muestra un alert normal
        alert(texto)
}

/******************FUNCION QUE FORMATEA UNA FECHA O UN PERIODO a YYYY-MM-DD******************/
/* Original:  Richard Gorremans (RichardG@spiritwolfx.com) -->
<!-- Web Site:  http://www.spiritwolfx.com -->

<!-- This script and many more are available free online at -->
<!-- The JavaScript Source!! http://javascript.internet.com -->
*/
// Check browser version
var isNav4 = false, isNav5 = false, isIE4 = false
var strSeperator = "-";//separador de fecha
// If you are using any Java validation on the back side you will want to use the / because 
// Java date validations do not recognize the dash as a valid date separator.
var vDateType = 3;// Global value for type of date format
//                1 = mm/dd/yyyy
//                2 = yyyy/dd/mm  (Unable to do date check at this time)
//                3 = dd/mm/yyyy
var vYearType = 4;//Set to 2 or 4 for number of digits in the year for Netscape
var vYearLength = 2;// Set to 4 if you want to force the user to enter 4 digits for the year before validating.
var err = 0;// Set the error code to a default of zero
if (navigator.appName == "Netscape") {
    if (navigator.appVersion < "5") {
        isNav4 = true;
        isNav5 = false;
    }
    else if (navigator.appVersion > "4") {
        isNav4 = false;
        isNav5 = true;
    }
}
else {
    isIE4 = true;
}

function dateFormat(vDateName, e, dateType) {
    //recibe el objeto del campo fecha y el evento
    vDateType = dateType;//1 tipo fecha, 2 tipo periodo
    vDateValue = vDateName.value;//el valor del campo fecha
    dateCheck = true;//revisa si la fecha ingresada es válida, si no le dá el foco al objeto para volver a ingresar la fecha
    // vDateName = object name
    // e = event
    // dateCheck=true 
    // True  = Verify that the vDateValue is a valid date
    // False = Format values being entered into vDateValue only
    // vDateType
    // 1 = yyyy-mm-dd
    // 2 = yyyy-mm
    //Enter a tilde sign for the first number and you can check the variable information.
    var whichCode = (window.Event) ? e.which : e.keyCode;
    // Check to see if a seperator is already present.
    // bypass the date if a seperator is present and the length greater than 8
    if (vDateValue == "")//si no ha digitado nada no aplica formato
        return true;
    if (((vDateType == 1 && vDateValue.length > 8) || (vDateType == 2 && vDateValue.length > 6))) {
        if ((vDateValue.indexOf("-") >= 1) || (vDateValue.indexOf("/") >= 1))
            return true;
    }
    if (validarSoloLetras(vDateValue)) {
        //la funcion esta en validaciones.js
        alert("Fecha inválida\nPor favor digítela de nuevo");
        vDateName.value = "";
        vDateName.focus();
        vDateName.select();
        return false;
    }
    if (whichCode == 8)//Ignore the Netscape value for backspace. IE has no value
        return false;
    else {
        //Create numeric string values for 0123456789/
        //The codes provided include both keyboard and keypad values
        var strCheck = '47,48,49,50,51,52,53,54,55,56,57,58,59,95,96,97,98,99,100,101,102,103,104,105';
        if (strCheck.indexOf(whichCode) !=  - 1) {
            // Reformat the date for validation and set date type to a 1
            if ((vDateType == 1 && vDateValue.length >= 8) || (vDateType == null && vDateValue.length >= 8)) {
                // yyyymmdd
                var mYear = vDateName.value.substr(0, 4)
                var mMonth = vDateName.value.substr(4, 2);
                var mDay = vDateName.value.substr(6, 2);
                vDateName.value = mYear + strSeperator + mMonth + strSeperator + mDay;
                if (!ValidaForma(vDateName.id, 'Fecha', 'isDate'))//valida que sea una fecha válida en validaciones.js
                {
                    vDateName.value = "";
                    vDateName.focus();
                    vDateName.select();
                    return false;
                }
            }
            else if ((vDateValue.length >= 6 && vDateType == 2) || (vDateValue.length >= 6 && vDateType == null))// yyyymm
            {

                var mYear = vDateName.value.substr(0, 4)
                var mMonth = vDateName.value.substr(4, 2);
                vDateName.value = mYear + strSeperator + mMonth;
                if (!ValidaForma(vDateName.id, 'Periodo', 'isPeriod'))//valida que sea un periodo válido en validaciones.js
                {
                    vDateName.value = "";
                    vDateName.focus();
                    vDateName.select();
                    return false;
                }
            }
            return true;
        }
        else {
            if ((vDateValue.length == 9 && dateCheck) && (vDateValue.length >= 1)) {
                alert("Fecha inválida\nPor favor digítela de nuevo");
                vDateName.value = "";
                vDateName.focus();
                vDateName.select();
                return false;
            }
        }

    }
}

//Coloca la rura en el tpitulo de la ventana, esto para saber donde esta ubicado el usuario
/*if (parent==null)
 document.title="SIA - "+window.location;//si es una pagina sola
else if (parent.parent!=null)
 parent.parent.document.title="SIA - "+window.location;//si es una página dentro de 2 frames
else 
 parent.document.title="SIA - "+window.location;//si es una página dentro de 1 frame
*/

//funcion para abrir la ayuda de la pagina en la cual se encuentre el usuaio
function ayuda(direccion) {
    direccion = direccion.src;
    var dir = direccion.toString();
    var vec = dir.split("/");
    var pg1 = vec[vec.length - 1].toString();
    var pg2 = pg1.split(".");
    var hlp = pg2[0].toString();

    if (hlp == "contenido" || hlp == "principal") {
        alert("Para poder ver la ayuda\ndebe seleccionar alguna opcion del menú");
    }
    else {
        window.open("../html/" + hlp + ".html", "", "top=150, left=180, width=700, height=600, location=no, status=no, toolbar=no, menubar=no, scrollbars=yes, resizable=no, ,titlebar=olocation=0");
    }

    //window.open("../html/ayuda.html", "", "top=150, left=180, width=700, height=600, location=no, status=no, toolbar=no, menubar=no, scrollbars=yes, resizable=no, ,titlebar=olocation=0");
}

function numberFormat(nStr, obj) {
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1))
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    obj.value = x1 + x2;
}

// This function removes non-numeric characters
function stripNonNumeric(str) {
    str += '';
    var rgx = /^\d|\.|-$/;
    var out = '';
    for (var i = 0;i < str.length;i++) {
        if (rgx.test(str.charAt(i))) {
            if (!((str.charAt(i) == '.' && out.indexOf('.') !=  - 1) || (str.charAt(i) == '-' && out.length != 0))) {
                out += str.charAt(i);
            }
        }
    }
    return out;
}

function darClick(name) {
    document.getElementById("form1:commandButtonNeg1").click();
    alert("Datos Actualizados " + document.getElementById("form1:commandButtonNeg1"));
}

function tabSeguimiento() {
    //alert( document.getElementById('form1:page1:inputTextSubFormSeguimiento3__xc_'));
    document.getElementById('form1:inputTextSubFormSeguimiento2__xc_').tabIndex = 1;
    document.getElementById('form1:inputTextSubFormSeguimiento3__xc_').tabIndex = 2;
    document.getElementById('form1:inputTextSubFormSeguimiento4__xc_').tabIndex = 3;
    document.getElementById('form1:inputTextSubFormSeguimiento5__xc_').tabIndex = 4;

}

function loguearUsuario() {

    with (event) {
        if (keyCode == 13) {
            document.getElementById('form1:commandButton1').onclick();
        }
    }
}

function tabReferencias() {
    //alert( document.getElementById('form1:page1:inputTextSubFormSeguimiento3__xc_'));
    document.getElementById('form1:inputTextSubFormReferencia1__xc_').tabIndex = 1;
    document.getElementById('form1:inputTextSubFormReferencia2__xc_').tabIndex = 2;
    document.getElementById('form1:inputTextSubFormReferencia3__xc_').tabIndex = 3;

    document.getElementById('form1:inputTextSubFormReferencia4__xc_').tabIndex = 4;
    document.getElementById('form1:inputTextSubFormReferencia8__xc_').tabIndex = 5;
    document.getElementById('form1:inputTextSubFormReferencia6__xc_').tabIndex = 6;
    document.getElementById('form1:inputTextSubFormReferencia7__xc_').tabIndex = 7;
    document.getElementById('form1:inputTextSubFormReferencia5__xc_').tabIndex = 8;

}

function checkActonIndemnizacion(obj, idInputHide, idLink) {

    var chk = obj.id;
    var btn = obj.id;

    btn = btn.substring(0, btn.lastIndexOf(":"));
    btn = btn + ":" + idLink;

    document.getElementById(idInputHide).value = chk;
    document.getElementById(btn).click();
}

function deshabilitarCampo() {
    var habilitar = false;
    // Se determina si se enviaron argumentos, los cuales seran los id's de los campos a habilitar/deshabilitar dependiendo lo seleccionado.
    if (arguments != null && arguments.length > 1) {
        for (indice = 1;indice < arguments.length;++indice) {
            // Se valida si el elemento existe por id.
            elemento = document.getElementById(arguments[indice]);

            // Se determina el valor del radio. 0:Habilitar, 1:Deshabilitar.
            if (arguments[0].value == "0")
                habilitar = true;
            else if (arguments[0].value == "1")
                habilitar = false;

            if (elemento != null) {
                if (habilitar) {
                    elemento.disabled = '';
                    elemento.style.background = "#ffffff";
                }
                else {
                    elemento.disabled = 'disabled';
                    elemento.style.background = "#dddddd";
                    elemento.value = "";
                }
            }
        }

        arguments[0].blur();
    }
}