"""
Routes and views for the flask application.
"""

from datetime import datetime
from flask import render_template
from AwarenessNews import app
import json
import requests



url = "https://coronavirus-19-api.herokuapp.com/countries"
data = requests.get(url)
resolved = data.json()

with open('countries.json', 'w+') as f:
    json.dump(resolved, f, sort_keys=True, indent=4)
f.close()



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

@app.route('/about')
def about():
    """Renders the about page."""
    return render_template(
        'about.html',
        title='About',
        year=datetime.now().year,
        message='Your application description page.'
    )



@app.route('/news')
def news():
    return render_template('news.html',
                           title='News',
                           result = get_countries(),
                          
                           )


def get_countries():
   with open('countries.json', 'r') as f:
       jsonData = json.load(f)
       
   f.close()
   return jsonData
