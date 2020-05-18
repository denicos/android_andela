"""
Routes and views for the flask application.
"""

from datetime import datetime
from flask import render_template
from Covid import app
import requests
import json
from Covid.models import covid
 




@app.route('/')
@app.route('/home')
def home():
    """Renders the home page."""
    return render_template(
        'index.html',
        title='Home Page',
        year=datetime.now().year,
    )
   

@app.route('/contact')
def contact():
    """Renders the contact page."""
    return render_template(
        'contact.html',
        title='Contact',
        year=datetime.now().year,
        message='Your contact page.'
    )
    fill_file()



@app.route('/about')
def about():
    """Renders the about page."""
    return render_template(
        'about.html',
        title='About',
        year=datetime.now().year,
        message='Your application description page.'
    )


## functions are placed here
## not any other place.
# def fill_file():
 #   url = "https://coronavirus-19-api.herokuapp.com/countries"
 #   data = requests.get(url)
 #   resolved = data.json()
    

 #   with open('countries.json', 'a') as f:
 #       json.dump(json_list, f, sort_keys=True, indent=4)