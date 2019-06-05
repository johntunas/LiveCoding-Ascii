// player de la clase Acordeon1
// con el metodo f la clase recibe strings que son interpretados para generar sonido.

~ac = Acordeon1.new // llama a la clase
~ac.run // play
~ac.stop// stop Ndef y Tdefs
~ac.kill // libera el Ndef que genera sonido


// espacio = silencio
// mayúsculas = sube pitch aleatorio
~ac.f = "xxxxxxxxxxxx       KKKKKKK"


// pueba con dibujos ascii
(
~ac.f = "
________________nnnn________________________________
___________--- dGGGGMMb     ,""""""""""--------------
------_____---@p~qp~~qMb   | Software Libre Rules! |
------_____---M|@||@) M|   _;.........................
------_____---@,----.JM| -'____________________________
------_____---JS^\__/  qKL_____________________________
__________dZP         qKRb------------------------------
-----_____-dZP           qKKb___________________________
_________fZP             SMMb___________________________
--_____---HZM             MMMM--------------------------
________FqM             MMMM------------------------------
--______---__|             \dSqML-------------------------
    _______|    `.        | `' \Zq_______________________
_______ _  |    \.___  .,   |     .'---------------------
  ___ \____   )MMMMMM|   .'-------------------------------
--______------- `-'       `--' hjm_______________________"
)
