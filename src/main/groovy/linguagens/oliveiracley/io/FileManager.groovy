package linguagens.oliveiracley.io

import linguagens.oliveiracley.ui.ANSI

class FileManager {


	def static readFile (String _file) {
		def file
		try{
			file = new Object() { }.getClass().getResource("/Files/${_file}")
		} catch(Exception e) {
			println "${ANSI.RED_BOLD} Error reading file: ${ANSI.RED_UNDERLINE} ${_file} ${ANSI.RESET}"
			println "${ANSI.WHITE}" 			+
					"${ANSI.RED_BACKGROUND} " 	+ 
						"${e.getMessage()}"		+
					"${ANSI.RESET}"
		}

		return file?.text
		// return decodeAssembly(cpu, file) //?.text
	}


	// def static decodeAssembly(CPU cpu, def file){
	// 	String assembly = file?.text as String
	// 	String[] code = assembly.split('\n')
	// 	Word[] temp = new Word[code.size()]
		
	// 	code.eachWithIndex{ word, i ->
	// 	// -Formating word string---------------------------------------
	// 		word =  word.replaceAll("^\\d+\\s+|^\\d+\\t+","")
	// 					.replaceAll("//.*","")
	// 		if(word.contains("\t"))
	// 			word = 	word.replaceFirst("\t",",")
	// 						.replaceAll("\t","")
	// 		else
	// 			word = 	word.replaceFirst(" ",",")
	// 						.replaceAll(" ","")

	// 		word = word.split(",")
	// 		word.eachWithIndex{ param, p -> 
	// 			if(param.toUpperCase().contains("R"))
	// 				word[p] = word[p].replaceFirst("R|r","")
	// 				// This line does exist if the register is on 1..8
	// 				// word[p] = (word[p] as int) - 1 
	// 			else if (param.contains("["))
	// 				word[p] = word[p].replaceAll("\\[|\\]","")
	// 		}
	// 	// -Translate the word to memory--------------------------------
	// 		try{
	// 			temp[i] = translator(word)
	// 		} catch (Exception e){
	// 			println "*** Invalided on LOAD ${i}, ${word}"
	// 			cpu.setInterruption(CPU.Interrupts.InvalidInstruction)
	// 		}
	// 	}
	
	// 	return temp
	// }


	// def static translator(def word) throws MissingPropertyException, NoSuchFieldException{
	// 	Core.OPCODE opcode
	// 	int r1, r2, p
	// 	r1 = r2 = p = 0

	// 	opcode = Core.OPCODE."${word[0].toUpperCase()}"
	// 	if( opcode.value.size() != word.size()-1 &&
	// 		opcode != Core.OPCODE.STOP )
	// 		throw new NoSuchFieldException()

	// 	opcode.value.eachWithIndex{ value, i ->
	// 		if 		(value == 1)	r1 = word[i + 1] as int
	// 		else if (value == 2)	r2 = word[i + 1] as int
	// 		else if (value == 3)	p  = word[i + 1] as int
	// 	}

	// 	return new Word(opcode, r1, r2, p)
	// }
}