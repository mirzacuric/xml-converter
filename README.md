# xml-converter
API for converting provided file content and converting it to the XML data format.

Steps to test:

1. First we need to clone the repo
  git clone https://github.com/mirzacuric/xml-converter.git
  
2. Open a project in InteliJ and run

3. Try to upload a file on desired route
  METHOD: POST
  URL: http://localhost:8080/api/v1/converter/convert
  BODY: file: {file}
  
  Example File content: {
    P|Carl Gustaf|Bernadotte
    T|0768-101801|08-101801
    A|Drottningholms slott|Stockholm|10001
    F|Victoria|1977
    A|Haga Slott|Stockholm|10002
    F|Carl Philip|1979
    T|0768-101802|08-101802
    P|Barack|Obama
    A|1600 Pennsylvania Avenue|Washington, D.C
  }
  
4. Response is as XML {
   <?xml version="1.0" encoding="UTF-8"?><people>
    <person>
      <firstname>Carl Gustaf</firstname>
      <address>
        <zipCode>10001</zipCode>
        <city>Stockholm</city>
        <street>Drottningholms slott</street>
      </address>
      <phone>
        <mobile>0768-101801</mobile>
        <landLine>08-101801</landLine>
      </phone>
      <family>
        <address>
          <zipCode>10002</zipCode>
          <city>Stockholm</city>
          <street>Haga Slott</street>
        </address>
        <born>ads</born>
        <name>Victoria</name>
      </family>
      <family>
        <phone>
          <mobile>0768-101802</mobile>
          <landLine>08-101802</landLine>
        </phone>
        <born>1979</born>
        <name>Carl Philip</name>
      </family>
      <lastname>Bernadotte</lastname>
    </person>
    <person>
      <firstname>Barack</firstname>
      <address>
        <city>Washington, D.C</city>
        <street>1600 Pennsylvania Avenue</street>
      </address>
      <lastname>Obama</lastname>
    </person>
  </people>
}
