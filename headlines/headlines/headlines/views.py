"""
Routes and views for the flask application.
"""

from datetime import datetime
from flask import render_template, request
from headlines import app
import feedparser


RSS_FEEDS = {'bbc': 'http://feeds.bbci.co.uk/news/rss.xml',
             'cnn' : 'http://rss.cnn.com/rss/edition.rss',
             'fox' : 'https://www.foxnews.com/about/rss/feedburner/foxnews/latest',
             'iol' : 'http://rss.iol.io/iol/news'}


@app.route('/')
@app.route('/home')
def home():
    """Renders the home page."""
    return render_template(
        'index.html',
        title='Home Page',
        year=datetime.now().year,
    )

@app.route('/contact', methods=['GET', 'POST'])
def contact():
    query = request.form.get("publication")
    if not query or query.lower() not in RSS_FEEDS:
        publication = "bbc"
    feed = feedparser.parse(RSS_FEEDS[publication])
    return render_template('contact.html',
                          articles = feed['entries'])
   

@app.route('/about')
def about():
    """Renders the about page."""
    return render_template(
        'about.html',
        title='About',
        year=datetime.now().year,
        message='Your application description page.'
    )
