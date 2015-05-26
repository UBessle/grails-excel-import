grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits("global") {
		// uncomment to disable ehcache
		// excludes 'ehcache'
	}

	log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	repositories {
		inherits 'global'
		grailsPlugins()
		grailsHome()
		grailsCentral()
		// uncomment the below to enable remote dependency resolution
		// from public Maven repositories
		mavenLocal()
		mavenCentral()
		//mavenRepo "http://snapshots.repository.codehaus.org"
		//mavenRepo "http://repository.codehaus.org"
		//mavenRepo "http://download.java.net/maven/2/"
		//mavenRepo "http://repository.jboss.com/maven2/"
	}

	dependencies {
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
		compile(group: 'org.apache.poi', name: 'poi', version: '3.11');
		//xlsx file support
		compile(group: 'org.apache.poi', name: 'poi-ooxml', version: '3.11') {
			excludes 'xmlbeans'
		}
		//xlsx schemas support
		compile(group: 'org.apache.poi', name: 'ooxml-schemas', version: '1.1') {
			excludes 'xmlbeans'
		}
		//compile group:'org.apache.poi', name:'poi-contrib', version:'3.7'
		//compile group:'org.apache.poi', name:'poi-scratchpad', version:'3.7' //ppt, word, visio, outlook support
		compile(group: 'commons-io', name: 'commons-io', version:'1.4')
	}

	plugins {
		compile ":joda-time:1.5"
		build ":release:3.1.1"
		build ":tomcat:7.0.54"
		build ":migrate2-grails3:0.3.2"
		// compile ':hibernate:3.6.10.15' {
		// 	export = false
		// }
	}
}
