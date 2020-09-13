package linguagens.oliveiracley


import linguagens.oliveiracley.io.FileManager
import linguagens.oliveiracley.ui.ANSI
import groovy.lang.Lazy

class Lexer {

    @Lazy
	static Properties properties
	public static final String propertiesFile = "/application.properties"

    public static void main(String[] args) {
    	// Import properties definitions
		new Object() {}  	
		    .getClass()
	    	.getResource( propertiesFile )
	    	.withInputStream {
	        	properties.load(it)
	    	}
			
		// Create a map of lexer pattern descriptions
		def descriptions = 
		properties.findAll { it ->
    		it.key.contains("description")
    	}

    	// Define global variables
    	def map = [:]
    	String state
 
    	// Run each file name got by args param
    	args.each{ file ->
    		// Load files by name (from resources folder)
    		def syntax = FileManager.readFile(file)
    			// Join in one string by break lines
    			syntax = syntax.join("\n")
    			// Delete all spaces
				syntax = syntax.replaceAll(" ","")

			// Loop throw the all file
			while(syntax){

				// Compare the syntax with all the descriptions given on properties
				descriptions.each { it ->
					state = syntax.replaceFirst("${it.value}", "")
					state = syntax.replace(state,"")

					// If the lexer has been found, 
					// the regex is saved on the map with 
					// the description and the lexer
					// pattern is removed from syntax
					if(state ==~ it.value ){
						map[state] = "${it.key}"
						syntax = syntax.replaceFirst("${it.value}","")
						return true
					}
				}

			// When the syntax is empty, all the patterns has been found
			}	
		}

		// Print all the patterns found
		println "TOKEN\t\tID\t\tDescription"
		map.each{ it ->
			def token = it.value.replace("lexer.description.","")
			def id = properties."lexer.identifier.${token}"
			println token + "\t\t" + id + "\t\t" + it.key
		}

	}

}