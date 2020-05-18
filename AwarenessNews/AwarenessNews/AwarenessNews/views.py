"""
Routes and views for the flask application.
"""

from datetime import datetime
from flask import render_template
from AwarenessNews import app

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
    return render_template('news.html', title='News', result = get_countries())


def get_countries():
    results =  {
        "active": 56689, 
        "cases": 276505, 
        "casesPerOneMillion": 5914, 
        "country": "Spain", 
        "critical": 1208, 
        "deaths": 27563, 
        "deathsPerOneMillion": 590, 
        "recovered": 192253, 
        "testsPerOneMillion": 64977, 
        "todayCases": 0, 
        "todayDeaths": 0, 
        "totalTests": 3037840
    }
    return results