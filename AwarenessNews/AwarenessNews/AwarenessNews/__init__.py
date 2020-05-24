"""
The flask application package.
"""
from jinja2.ext import Extension

from flask import Flask
app = Flask(__name__)
app.jinja_options['extensions'].append('jinja2.ext.loopcontrols')

import AwarenessNews.views

