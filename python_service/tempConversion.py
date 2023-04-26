from spyne import Application, rpc, ServiceBase
from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication
from spyne import Decimal, Integer, Unicode
from zeep import Client

class TemperatureConversionService(ServiceBase):
    @rpc(Decimal, _returns=Decimal)
    def fahrenheit_to_celsius(ctx, fahrenheit):
        # Connect to the external SOAP API
        client = Client('https://www.w3schools.com/xml/tempconvert.asmx?WSDL')
        # Call the Fahrenheit to Celsius conversion method
        result = client.service.FahrenheitToCelsius(fahrenheit)
        # Convert the result to Decimal and return
        return Decimal(result)

# Create a Spyne application with the TemperatureConversionService
application = Application([TemperatureConversionService],
                          tns='tempconvert',
                          in_protocol=Soap11(validator='lxml'),
                          out_protocol=Soap11())

# Wrap the Spyne application with a WsgiApplication

# Serve the Spyne application using a WSGI server of your choice (e.g., gunicorn, uwsgi)
# Example using gunicorn:
# gunicorn -b 0.0.0.0:8000 my_service:application


if __name__ == '__main__':
    from wsgiref.simple_server import make_server

    # Define the SOAP service
    app = Application([TemperatureConversionService], 'TemperatureConversionService')
    wsgi_application = WsgiApplication(application)

    # Start the SOAP server
    server = make_server('0.0.0.0', 7134, wsgi_application)
    server.serve_forever()
