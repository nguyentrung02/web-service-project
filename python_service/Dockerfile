# Dockerfile for Python SOAP service

# Use the official Python base image
FROM python:3.9

# Set the working directory in the container
WORKDIR /app

# Copy the service files to the container
COPY . /app

# Install dependencies
RUN pip install zeep
RUN pip install spyne

# Expose the port used by the service
EXPOSE 5000

# Run the SOAP service
CMD ["python", "soap_service.py"]