var $=jQuery.noConflict();

$(document).ready(function(){
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
      })
      
      
      $(function() {
          if(!loggedin) {
            var userLang = navigator.language || navigator.userLanguage; 
        document.getElementById("country").value = userLang;
        if(qs["open"] != null) {
            if(qs["open"] == "login") {
                console.log("login");
                $("#login").modal()
            }else if(qs["open"] == "register") {
                $("#register").modal()
            }
        }
        var l = qs["l"];
        var btn = '<button type="button" class="close" data-dismiss="alert" aria-label="Close"\><span aria-hidden="true">&times;</span\></button\>'
        if(l != null) {
            document.getElementById('alert-login').innerHTML = '<div id="inr" class="alert rlalert alert-danger alert-dismissible fade show" role="alert"\></div>';
            if(l == "li") {
                document.getElementById('inr').innerHTML = 'Die angegebenen Daten sind Fehlerhaft.' + btn
            }else if(l=="ll") {
                document.getElementById('inr').innerHTML = 'Dein Gerät wurde für das einloggen kurzzeitig gesperrt.' + btn
            }else if(l=="lub") {
                document.getElementById('inr').innerHTML = 'Dein Nutzer Account wurde gesperrt, für weitere Informationen schreibe uns eine Email <a href="mailto:info@wolkennet.de">info@wolkennet.de</a>' + btn
            }else if(l=="lnp") {
                document.getElementById('inr').innerHTML = 'Du hast keine Berechtigung um dich dort zu bewegen' + btn
            }
        }
        var r = qs["r"];
        if(r !=null) {
            document.getElementById('alert-register').innerHTML = '<div id="inrr" class="alert rlalert alert-danger alert-dismissible fade show" role="alert"\></div>';
            if(r == "ret") {
                document.getElementById('inrr').innerHTML = 'Die Email Adresse ist vergeben.' + btn
            }else if(r=="rut") {
                document.getElementById('inrr').innerHTML = 'Der Nutzername ist vergeben.' + btn
            }else if(r=="rul") {
                document.getElementById('inrr').innerHTML = 'Der Nutzername ist zu lang.' + btn
            }else if(r=="rus") {
                document.getElementById('inrr').innerHTML = 'Du darfst keine Leerzeichen in deinem Namen nutzen, nutze doch (!,_,+,/).' + btn
            }else if(r=="rel") {
                document.getElementById('inrr').innerHTML = 'Die Email Adresse ist zu lang.' + btn
            }else if(r=="rts") {
                document.getElementById('inrr').innerHTML = 'Dein Passwort ist zu kurz.' + btn
            }else if(r=="rie") {
                document.getElementById('inrr').innerHTML = 'Deine Email Adresse ist fehlerhaft.' + btn
            }else if(r=="re") {
                document.getElementById('inrr').innerHTML = 'Ein interner Fehler ist aufgetreten, wir versuchen das so schnell wie möglich zu reparieren.' + btn
            }else if(r=="rd") {
                document.getElementById('inrr').innerHTML = 'Registrierungen sind momentan deaktiviert, versuche es bitte später nochmal.' + btn
            }
        }
          }
        
    });
});

function onSubmit(token) {
    document.getElementById("rl-form").submit();
}

function logout() {
    document.cookie = "session" + '=; Max-Age=0'
    location.reload();
}


var qs = (function(a) {
    if (a == "") return {};
    var b = {};
    for (var i = 0; i < a.length; ++i)
    {
        var p=a[i].split('=', 2);
        if (p.length == 1)
            b[p[0]] = "";
        else
            b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
    }
    return b;
})(window.location.search.substr(1).split('&'));