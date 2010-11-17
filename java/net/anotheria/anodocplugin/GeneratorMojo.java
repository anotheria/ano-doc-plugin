package net.anotheria.anodocplugin;

import java.io.File;

import net.anotheria.asg.generator.Generator;
import net.anotheria.asg.generator.util.FileWriter;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Generates ano-doc classes.
 * 
 * @goal generate
 * @phase generate-sources
 * @execute phase="generate-sources" 
 *
 */
public class GeneratorMojo extends AbstractMojo{
	
	/**
	 * My base dir.
	 * @parameter
	 */
	private String baseDir;
	
	/**
	 * My output
	 * @parameter
	 */
	private String outputDir;
	
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		try{
			log("Starting generation with "+Generator.getProductString()+" into: "+outputDir+" from: "+baseDir);
			FileWriter.setBaseDir(outputDir);
			Generator.setBaseDir(baseDir+File.separatorChar);
			Generator.generate();
			log("Generation complete");
		}catch(Exception e){
			log("Error: "+e.getMessage());
		}
		
	}
	
	private void log(Object msg){
		getLog().info(""+msg);
	}

}
