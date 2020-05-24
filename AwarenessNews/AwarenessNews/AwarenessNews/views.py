"""
Routes and views for the flask application.
"""

from datetime import datetime
from flask import render_template, request
from AwarenessNews import app
import json
import requests
import matplotlib.pyplot as plt



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

@app.route('/causes')
def causes():
    return render_template('causes.html')

@app.route('/about',methods=['GET', 'POST'])
def about():
    """Renders the about page."""
    return render_template(
        'about.html',
        title='About',
        sit = search_country(),
    )



@app.route('/news')
def news():
    return render_template('news.html',
                           title='News',
                           result = create_countries_list()
                          
                           )


def create_countries_list():
    with open('countries.json', 'r') as f:
       jsonData = json.load(f)

    county = []
    for x in jsonData:
       county.append({
           "country" : x["country"],
           "cases" : x["cases"],
           "active" : x["active"],
           "todayCases" : x["todayCases"],
           "recovered" : x["recovered"],
           "deaths" : x["deaths"],
           "todayDeaths" :x["todayDeaths"],
           "totalTests" : x["totalTests"]
           })
       
    f.close()
    return county

def search_country():
    with open('countries.json', 'r') as f:
       jsonData = json.load(f)

    county = []
    for x in jsonData:
       county.append({
           "country" : x["country"],
           "cases" : x["cases"],
           "active" : x["active"],
           "todayCases" : x["todayCases"],
           "recovered" : x["recovered"],
           "deaths" : x["deaths"],
           "todayDeaths" :x["todayDeaths"],
           "totalTests" : x["totalTests"]
           })

    name = "Uganda"
    searched = list(filter(lambda coun : coun['country'] == name, county))
       
    f.close()
    return searched
