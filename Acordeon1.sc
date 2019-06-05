

Acordeon1{
var <>f = "-------------";
var  <> tempo;


*new{ arg f;
^super.new.init;

}

init{
		     tempo = TempoClock.new(110/60); // tempo general
// -----Pluck--------------------------------------
Ndef(\pluck,{|freq = 2, amp = 0.3, delTime = 0.2, decay= 1, coef = 0.5|

Pan2.ar(
		FreeVerb.ar(
	Pluck.ar(
		BrownNoise.ar(0.4),
		Impulse.kr(freq),0.2,
		delTime,
		SinOsc.kr(decay).range(0.13,8),//decay,
		coef,  //
), 0.4, damp: 0.7
), 0, Lag.kr(amp,0.5)) });

//-------------------------------Tdefs---------------------------------
Tdef(\tdefPluck,{

var amp = 1, deltime = 0.1, time;
	inf.do{arg i;

		time = 	[0.5,0.25].choose;

		// amplitud
		if(f[ i % f.size].ascii >= 49 && (f[i % f.size].ascii <= 57),{ amp = f[i % f.size].digit * 0.1},{amp = 0.90});
		if(f[ i % f.size].ascii == 32,{ amp = 0.0});
		// deltime
		if(f[ i % f.size].isUpper, { deltime = rrand(0.09,0.26) * f[ i % f.size].ascii.reciprocal.abs}, {deltime = f[ i % f.size].ascii.reciprocal.abs} ) ;

	Ndef(\pluck).set(\freq, time.reciprocal,
			\delTime, deltime, \decay,  f[ i % f.size].ascii.reciprocal.abs,
			\coef, (0.35.rand +  f[ i % f.size].ascii.reciprocal.abs),\amp,amp);

time.wait}});


//-------imprime dibujos-------------------------------------------------------------
	Tdef(\postAscii,{
			var text="", puente;
			var amp;
	inf.do{arg i;
		text="";
	puente=Array.fill(40.rand,{["@"," ~"," ¡","______________________
lllllllllllllll      ())()()()",
		"
                  /|  /|
                 ||__||  |             |----------------------------|
               /     O O\__         |     -satyagraha-       |
              /               i\        |     --satyagraha--     |
             /         i\        i\     |                              |
            /   _       i\        i\   |----------------------------|
           /      |\____  i\     i \           ||
          /          | | | |\____/            ||
         /             \| | | |/ |           __||
        /     /  \   -------         |____|   ||
       /       |   |                  |           --|
       |     |   |                   |_____    --|
       |       |_|_|_|            |          \----
       /\                          |
      / /\          |             /
     / /  |          |            |
 ___/ /   |         |          |
|____/    c_c_c_C/ \C_c_c_c" ,
					"()(/$∞¬÷““”≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠≠"
				].wchoose([3,3,1,3,1,2].normalizeSum)});

puente.size.do({|i| text=text++puente[i];});
text.postln;
				(0.1+0.82.rand.round(0.2)).wait}})


	}


run{
		Ndef(\pluck).play;Tdef(\tdefPluck).play(tempo).quant = 1; Tdef(\postAscii).play
}

stop{
		Ndef(\pluck).stop(1);Tdef(\tdefPluck).stop;Tdef(\postAscii).stop
}

kill{
		Ndef(\pluck).clear(1);
	}

}